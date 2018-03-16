/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.homeworks.session5;

import masterdegree.ada.sort.InsertionComparation;

/**
 *
 * @author angel_banuelos
 */
public class Student implements InsertionComparation{

    private String name;
    private int index = -1;
    private boolean selected = false;

    public Student(String name) {
        this.name = name;
    }

    public int getOrder() {
        return index;
    }

    public void setOrder(int index) {
        this.index = index;
    }

    public boolean isSelected() {
        return selected;
    }

    @Override
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.index;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.index != other.index) {
            return false;
        }
        return true;
    }

    @Override
    public int getIndex() {
        return index;
    }
    
}
