package com.company.service.impl;

import com.company.model.Product;
import com.company.service.GeneralManagerService;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManager implements GeneralManagerService<Product> {

    private ArrayList<Product> listProduct;

    public ProductManager(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public ProductManager() {
        listProduct = new ArrayList<>();
    }


    @Override
    public void add() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập Id : ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhập tên sản phẩm : ");
        String name = sc.nextLine();
        System.out.print("Nhập giá:");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.print("Nhập số lượng : ");
        int amount = sc.nextInt();
        sc.nextLine();
        listProduct.add(new Product(id, name, price, amount));
    }

    @Override
    public int findIndexById(int id) {
        for (int i=0; i<listProduct.size(); i++){
            if (listProduct.get(i).getId() == id) return i;
        }
        return -1;
    }

    @Override
    public void update() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập Id sản phẩm cần sửa : ");
        int id = sc.nextInt();
        sc.nextLine();
        int index = findIndexById(id);
        if (index == -1) System.out.println("Sản phẩm cần sửa không có trong danh sách");
        else{
            System.out.print("Nhập Id sản phẩm mới  : ");
            int newId = sc.nextInt();
            sc.nextLine();
            System.out.print("Nhập tên sản phẩm mới  : ");
            String name = sc.nextLine();
            System.out.print("Nhập giá:");
            double price = sc.nextDouble();
            sc.nextLine();
            System.out.print("Nhập số lượng : ");
            int amount = sc.nextInt();
            sc.nextLine();
            listProduct.set(index, new Product(newId, name, price, amount));
        }
    }

    @Override
    public void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập Id sản phẩm cần xóa : ");
        int id = sc.nextInt();
        sc.nextLine();
        int index = findIndexById(id);
        if (index == -1) System.out.println("Sản phẩm cần xóa không có trong danh sách");
        else
        listProduct.remove(index);
    }

    @Override
    public void print() {
        for (int i=0; i<listProduct.size(); i++){
            System.out.println(listProduct.get(i));
        }
    }

    @Override
    public void findProductByName() {
        Scanner sc = new Scanner(System.in);
        String name;
        System.out.print("Nhập tên sản phẩm cần tìm : ");
        name = sc.nextLine();
        boolean find = false;
        int indexOf = -1;
        for (int i=0; i<listProduct.size(); i++){
            if (listProduct.get(i).getName().equals(name)) {
                find = true;
                indexOf = i;
                break;
            }
        }
        if (find)
            System.out.println(listProduct.get(indexOf));
        else {
                System.out.println("Sản phẩm không có trong danh sách");
            }
        }


    @Override
    public void sort() {
        listProduct.sort(Comparator.comparingDouble(Product::getPrice));
    }

    @Override
    public void sortDESC() {
        listProduct.sort((p1,p2) -> (int) (p2.getPrice() - p1.getPrice()));
    }


}
