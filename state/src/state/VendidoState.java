package state;

public class VendidoState implements State {
    private MaquinaGoma maquina;

    public VendidoState(MaquinaGoma maquina) {
        this.maquina = maquina;
    }

    @Override
    public void inserirMoeda() {
        System.out.println("Aguarde, estamos entregando sua goma.");
    }

    @Override
    public void ejectarMoeda() {
        System.out.println("Você já girou a alavanca, não pode devolver a moeda.");
    }

    @Override
    public void acionarAlavanca() {
        System.out.println("Girar novamente não vai te dar outra goma!");
    }

    @Override
    public void entregar() {
        maquina.liberarGoma();
        if (maquina.getCount() > 0) {
            maquina.setState(maquina.getSemMoedaState());
        } else {
            System.out.println("Acabaram as gomas!");
            maquina.setState(maquina.getEsgotadoState());
        }
    }
}