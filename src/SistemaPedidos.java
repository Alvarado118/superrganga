import java.util.LinkedList;
import java.util.Queue;

public class SistemaPedidos {
    private Queue<Pedido> colaPedidos = new LinkedList<>();
    private void registrarTransaccion(String accion, Pedido pedido) {
        System.out.println("Registro de transacción - Acción: " + accion + ", Pedido ID: " + pedido.id);
    }

    public void procesarPedido(Pedido pedido) {
        colaPedidos.offer(pedido);
        registrarTransaccion("Nuevo Pedido", pedido);
    }
    public Pedido recuperarPedidoPerdido() {
        if (!colaPedidos.isEmpty()) {
            Pedido pedidoRecuperado = colaPedidos.poll();
            registrarTransaccion("Recuperar Pedido Perdido", pedidoRecuperado);
            return pedidoRecuperado;
        } else {
            System.out.println("No hay pedidos perdidos para recuperar.");
            return null;
        }
    }

    public static void main(String[] args) {
        SistemaPedidos sistema = new SistemaPedidos();

        sistema.procesarPedido(new Pedido("001"));
        sistema.procesarPedido(new Pedido("002"));
        sistema.procesarPedido(new Pedido("003"));
        Pedido pedidoRecuperado = sistema.recuperarPedidoPerdido();
    }
}
