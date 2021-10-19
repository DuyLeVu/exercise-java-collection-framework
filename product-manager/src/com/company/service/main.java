package com.company.service;

import com.company.model.Product;
import com.company.service.impl.ProductManager;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductManager productService = new ProductManager();
        while (true){
            display();
            System.out.println("Nhập lựa chọn:");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    productService.add();
                    break;
                case 2:
                    productService.delete();
                    break;
                case 3:
                    productService.print();
                    break;
                case 4:
                    productService.findProductByName();
                    break;
                case 5:
                    productService.update();
                    break;
                case 6:
                    productService.sort();
                    break;
                case 7:
                    productService.sortDESC();
                    break;

                case 0:
                    System.exit(0);
            }
        }

    }
    public static void display(){
        System.out.println("==================Menu===============");
        System.out.println("1. Thêm sản phẩm");
        System.out.println("2. Xoá sản phẩm");
        System.out.println("3. Hiển thị danh sách sản phẩm");
        System.out.println("4. Tìm kiếm sản phẩm theo tên");
        System.out.println("5. Sửa sản phẩm theo Id");
        System.out.println("6. Sắp xếp sản phẩm tăng dần theo giá");
        System.out.println("7. Sắp xếp sản phẩm giảm dần theo giá");
        System.out.println("0. Thoát");

    }
}
