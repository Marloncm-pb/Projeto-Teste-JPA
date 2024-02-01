package org.project.application;

import org.project.product.Product;
import org.project.product.ProductResource;

import javax.swing.*;
import java.util.List;

public class ProductMenuController {
    public static void run(){
        int choice;
        Long id;
        try {
            do {
                String input = JOptionPane.showInputDialog("Selecione uma opção:\n" +
                        "1. Listar todos os Produtos\n" +
                        "2. Buscar um produto\n" +
                        "3. Cadastrar produto\n" +
                        "4. Atualizar Produto\n" +
                        "5. Excluir Produto");

                choice = Integer.parseInt(input);

                switch (choice) {

                    case 1:
                        List<Product> products = ProductResource.getProducts();
                        String list = "";
                        for (Product p : products) {
                            list += p.toString() + "\n";
                        }
                        JOptionPane.showMessageDialog(null, "Produtos:\n" + list);
                        break;
                    case 2:
                       id = Long.parseLong(JOptionPane.showInputDialog(null, "Informe o ID do Produto"));
                       Product p = ProductResource.getProduct(id);
                       JOptionPane.showMessageDialog(null, p.toString());

                       break;
                    case 3:
                        JOptionPane.showMessageDialog(null,newProduct().toString());
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, updateProduct().toString());
                        break;
                    case 5:
                        id = Long.parseLong(JOptionPane.showInputDialog(null, "Informe o ID do Produto que deseja excluir"));
                        ProductResource.deleteProduct(id);
                        JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida", "Erro", JOptionPane.ERROR_MESSAGE);
                        break;
                }

            } while (true);

        } catch (NumberFormatException e) {//quando usuário clica em cancelar
            return; //volta para o menu inicial
        }

    }

    public static Product newProduct(){
        try {
            String name = JOptionPane.showInputDialog("Digite o nome do produto:");
            while (name.length() < 2) {
                name = JOptionPane.showInputDialog("Nome deve ter no mínimo 2 caracteres:");
            }

            String description = JOptionPane.showInputDialog("Digite a descrição do produto:");
            while (description.length() < 10) {
                description = JOptionPane.showInputDialog("Descrição deve ter no mínimo 10 caracteres:");
            }

            double value = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do produto:"));
            while (value <= 0) {
                value = Double.parseDouble(JOptionPane.showInputDialog("Valor deve ser positivo:"));
            }
            Product product = new Product(name, description, value);

            ProductResource.insertProduct(product);

            return product;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Informe um número válido!");
            return null;
        }catch (NullPointerException e){
            JOptionPane.showMessageDialog(null,"Nome e Descrição são obrigatórios!");
            return null;
        }
    }

    public static Product updateProduct(){
        try {
            Long id = Long.parseLong(JOptionPane.showInputDialog("Digite o ID do produto que deseja atualizar:"));
            Product product = ProductResource.getProduct(id);
            String name = JOptionPane.showInputDialog("Digite o nome do produto:");
            while (name.length() < 2) {
                name = JOptionPane.showInputDialog("Nome deve ter no mínimo 2 caracteres:");
            }

            String description = JOptionPane.showInputDialog("Digite a descrição do produto:");
            while (description.length() < 10) {
                description = JOptionPane.showInputDialog("Descrição deve ter no mínimo 10 caracteres:");
            }

            double value = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do produto:"));
            while (value <= 0) {
                value = Double.parseDouble(JOptionPane.showInputDialog("Valor deve ser positivo:"));
            }
            product.setName(name);
            product.setDescription(description);
            product.setValue(value);

            ProductResource.updateProduct(id, product);

            return product;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Informe um número válido!");
            return null;
        }catch (NullPointerException e){
            JOptionPane.showMessageDialog(null,"Nome e Descrição são obrigatórios!");
            return null;
        }
    }

}