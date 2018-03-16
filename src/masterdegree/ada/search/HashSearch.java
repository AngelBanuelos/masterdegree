package masterdegree.ada.search;

import java.io.BufferedReader;
import java.io.FileReader;

public class HashSearch {

    static int HASH_LIST_SIZE = 0;

    static class Customer {

        String rfc;
        String name, address;
        int index;

        public Customer(String rfc, String name, String address, int index) {
            this.rfc = rfc;
            this.name = name;
            this.address = address;
            this.index = index;
        }
    }

    static Customer[] readCustomers(String filename) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line = br.readLine().trim();
        final int COUNT = Integer.parseInt(line);
        Customer[] customers = new Customer[COUNT];
        for (int i = 0; i < COUNT; i++) {
            line = br.readLine();
            String[] rowData = line.split("\t");
            customers[i] = new Customer(rowData[1].trim(), rowData[0].trim(), rowData[2].trim(), i);
        }
        br.close();
        return customers;
    }

    public static Customer search(String rfc, CustomerNode[] hastList) {
        int h = hashcode(rfc);
        CustomerNode node = hastList[h];
        while (node != null) {
            if (node.customer.rfc.equals(rfc)) {
                return node.customer;
            }
            node = node.getCustomerNodeNext();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        int m = 1000;
        String[] lookup = new String[m];
        Customer[] customers = readCustomers("Clientes.txt");
        HASH_LIST_SIZE = customers.length;

        for (int i = 0; i < m; i++) {
            int randomIndex = (int) (HASH_LIST_SIZE * Math.random());
            lookup[i] = customers[randomIndex].rfc;
        }

        System.out.println(" " + customers[0].rfc);
        System.out.println("" + hashcode(customers[0].rfc));

        System.out.println(" " + customers[2].rfc);
        System.out.println("" + hashcode(customers[2].rfc));

        System.out.println(" " + customers[3].rfc);
        System.out.println("" + hashcode(customers[3].rfc));

        System.out.println(" " + customers[65].rfc);
        System.out.println("" + hashcode(customers[65].rfc));

        CustomerNode[] hashList = CustomerNode.createCustomerHashList(customers);

        Customer s = search("HESJ740606F51", hashList);
        System.out.println("" + (s != null ? s.name : ""));

        long start = System.currentTimeMillis();
        for (int i = 0; i < m; i++) {
            search(lookup[i], hashList);
        }
        long end = System.currentTimeMillis();
        System.out.println("Duration: " + (end - start));
    }

    public static int hashcode(String rfc) {
        // 0 .. 9 --> 0-9
        // A .. Z --> 10-35
        int h = getValue(rfc.charAt(0));

        for (int i = 1; i < rfc.length(); i++) {
            h = (h * 36 + getValue(rfc.charAt(i))) % HASH_LIST_SIZE;
        }

        return h;
    }

    public static int getValue(char c) {
        int h = 0;
        if (Character.isDigit(c)) {
            return c - '0';
        } else {
            return c - 'A' + 10;
        }
    }

    static class CustomerNode {

        Customer customer;
        CustomerNode customerNodeNext;

        public CustomerNode(Customer customer) {
            this.customer = customer;
            this.customerNodeNext = null;
        }

        public static CustomerNode[] createCustomerHashList(Customer[] customers) {
            CustomerNode[] hashList = new CustomerNode[HASH_LIST_SIZE];
            for (Customer customer : customers) {
                int h = hashcode(customer.rfc);
                CustomerNode nodeToAdd = new CustomerNode(customer);
                CustomerNode currentNode = hashList[h];
                if (currentNode == null) {
                    hashList[h] = nodeToAdd;
                } else {
                    while (currentNode.customerNodeNext != null) {
                        currentNode = currentNode.customerNodeNext;
                    }
                    currentNode.customerNodeNext = nodeToAdd;
                }

            }
            return hashList;
        }

        public Customer getCustomer() {
            return customer;
        }

        public CustomerNode getCustomerNodeNext() {
            return customerNodeNext;
        }

    }

}
