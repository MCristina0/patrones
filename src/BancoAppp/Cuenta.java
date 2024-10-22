package BancoAppp;

public class Cuenta {
    private String titular;
    private double saldo;

    public Cuenta(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) throws MontoInvalidoException {
        if (monto <= 0) {
            throw new MontoInvalidoException("El monto a depositar debe ser mayor a cero.");
        }
        saldo += monto;
        System.out.println("Se han depositado $" + monto + ". Saldo actual: $" + saldo);
    }

    public void retirar(double monto) throws SaldoInsuficienteException, MontoInvalidoException {
        if (monto <= 0) {
            throw new MontoInvalidoException("El monto a retirar debe ser mayor a cero.");
        }
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para retirar $" + monto);
        }
        saldo -= monto;
        System.out.println("Se han retirado $" + monto + ". Saldo actual: $" + saldo);
    }

    public void transferir(Cuenta destino, double monto) throws SaldoInsuficienteException, MontoInvalidoException {
        if (monto <= 0) {
            throw new MontoInvalidoException("El monto a transferir debe ser mayor a cero.");
        }
        this.retirar(monto);
        destino.depositar(monto);
        System.out.println("Se ha transferido $" + monto + " a la cuenta de " + destino.getTitular());
    }
}
