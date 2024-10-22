package BancoAppp;

import java.util.Scanner;

public class BancoApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear cuentas de ejemplo
        Cuenta cuenta1 = new Cuenta("Juan", 1000);
        Cuenta cuenta2 = new Cuenta("Maria", 500);

        try {
            // Operación de depósito
            System.out.print("Ingrese el monto a depositar en la cuenta de Juan: ");
            double montoDeposito = scanner.nextDouble();
            cuenta1.depositar(montoDeposito);

            // Operación de retiro
            System.out.print("Ingrese el monto a retirar de la cuenta de Juan: ");
            double montoRetiro = scanner.nextDouble();
            cuenta1.retirar(montoRetiro);

            // Operación de transferencia
            System.out.print("Ingrese el monto a transferir de Juan a Maria: ");
            double montoTransferencia = scanner.nextDouble();
            cuenta1.transferir(cuenta2, montoTransferencia);

            // Mostrar saldo final de ambas cuentas
            System.out.println("Saldo final de Juan: $" + cuenta1.getSaldo());
            System.out.println("Saldo final de Maria: $" + cuenta2.getSaldo());

        } catch (SaldoInsuficienteException | MontoInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
