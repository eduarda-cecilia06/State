package state;

@SuppressWarnings("unused")
public class EsgotadoState implements State {
    private MaquinaGoma maquina;

    public EsgotadoState(MaquinaGoma maquina) {
        this.maquina = maquina;
    }

    @Override
    public void inserirMoeda() {
        System.out.println("Máquina sem gomas. Moeda devolvida.");
    }

    @Override
    public void ejectarMoeda() {
        System.out.println("Você não inseriu moeda.");
    }

    @Override
    public void acionarAlavanca() {
        System.out.println("Máquina sem gomas. Alavanca não funciona.");
    }

    @Override
    public void entregar() {
        System.out.println("Sem gomas para entregar.");
    }
}