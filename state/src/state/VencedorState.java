package state;

public class VencedorState implements State {
    private MaquinaGoma maquina;

    public VencedorState(MaquinaGoma maquina) {
        this.maquina = maquina;
    }

    @Override
    public void inserirMoeda() {
        System.out.println("Aguarde, estamos entregando suas gomas.");
    }

    @Override
    public void ejectarMoeda() {
        System.out.println("Você já girou a alavanca.");
    }

    @Override
    public void acionarAlavanca() {
        System.out.println("Girar novamente não vai te dar mais gomas!");
    }

    @Override
    public void entregar() {
        System.out.println("PARABÉNS! Você ganhou uma goma extra!");
        maquina.liberarGoma();
        if (maquina.getCount() == 0) {
            maquina.setState(maquina.getEsgotadoState());
        } else {
            maquina.liberarGoma();
            if (maquina.getCount() > 0) {
                maquina.setState(maquina.getSemMoedaState());
            } else {
                System.out.println("Acabaram as gomas!");
                maquina.setState(maquina.getEsgotadoState());
            }
        }
    }
}