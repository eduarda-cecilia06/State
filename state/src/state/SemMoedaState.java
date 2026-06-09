package state;

public class SemMoedaState implements State {
    private MaquinaGoma maquina;

    public SemMoedaState(MaquinaGoma maquina) {
        this.maquina = maquina;
    }

    @Override
    public void inserirMoeda() {
        System.out.println("Moeda inserida! Agora você pode girar a alavanca.");
        maquina.setState(maquina.getComMoedaState());
    }

    @Override
    public void ejectarMoeda() {
        System.out.println("Você não inseriu nenhuma moeda.");
    }

    @Override
    public void acionarAlavanca() {
        System.out.println("Você girou, mas não há moeda inserida.");
    }

    @Override
    public void entregar() {
        System.out.println("Nenhuma goma para entregar. Insira uma moeda primeiro.");
    }
}