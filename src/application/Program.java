package application;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import java.util.ArrayList;

public class Program {
    
    public static void main(String[] args) {
        Locale.setDefault(Locale.US); //separador de decimal o "."
        Scanner sc = new Scanner(System.in); //objeto para ler os dados do teclado.
        List<Employee> list = new ArrayList<>();
        System.out.println("Quantos funcionarios vão ser registrados? ");
        int N = sc.nextInt();

        for(int i=0; i<N; i++) {
            System.out.println();
            System.out.println("funcionario #" + (i +1) +":");
            System.out.print("ID: ");
            Integer id = sc.nextInt();
            while (hasId(list, id)) {
                System.out.println("Este Id já existe! Digite outro: ");
                id = sc.nextInt();
                
            }



            System.out.print("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salario: ");
            Double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, salary); //objeto estanciado do tipo Employee

            list.add(emp);  //objeto adcionado a lista
        }

        System.out.print("Coloque o ID do funcionario que você quer alterar o salario: ");
        int idsalary = sc.nextInt();                            //o id do funcionario que queremos mudar o valor
        
        Employee emp = list.stream().filter(x -> x.getId() == idsalary).findFirst().orElse(null);//
        
        // Integer pos = position(list, idsalary);                 // chamada da função passando os valores nosso como nossa lista de funcionarios e o id do funcionario que queremos mudar o salario
        if (emp == null) {                                      // verificando caso o id não exista retorno null da função position
            System.out.println("Esse id não existe");
            
        }
        else {
            System.out.print("Digite a porcentagem: ");
            double percent = sc.nextDouble();
            emp.increaseSalary(percent);              // chamda da função da clase employee para incrementar o aumento do salario
        }

        System.out.println();
        System.out.println("Lista de Funcionarios");
        for (Employee e : list) {                             //imprimindo a lista de funcionarios
            System.out.println(e);
        } 



        sc.close(); //fechar o objeto Scanner
    
    }

    public static Integer position(List<Employee> list, int id) { //Função modelo para receber a lista e o id do funcionario procurado
        for(int i=0; i<list.size(); i++) {          //como as posições da lista são como o i então retornamos ele mesmo na função
            if(list.get(i).getId() == id) {
                return i;
            }
        }
        return null;
         
    }

    public static boolean hasId(List<Employee> list, int id) { //Função modelo para verificar se o id existe
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }

}
