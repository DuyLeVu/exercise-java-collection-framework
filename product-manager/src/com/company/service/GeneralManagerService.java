package com.company.service;

public interface GeneralManagerService<T> {
    void add();

    int findIndexById(int id);

    void update ();

    void delete();

    void print();

    void findProductByName();

    void sort();

    void sortDESC();
}
