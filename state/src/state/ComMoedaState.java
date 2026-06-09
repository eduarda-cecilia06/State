package state;

import java.util.Random;

public class ComMoedaState implements State {
    private MaquinaGoma maquina;
    private Random random = new Random();

    public ComMoedaState(MaquinaGoma maquina) {
        this.maquina = maquina;
    }

    @Override
    public void inserirMoeda() {
        System.out.println("Você já inseriu uma moeda.");
    }

    @Override
    public void ejectarMoeda() {
        System.out.println("Moeda devolvida.");
        maquina.setState(maquina.getSemMoedaState());
    }

    @Override
    public void acionarAlavanca() {
        System.out.println("Você girou a alavanca...");
        int vencedor = random.nextInt(10);
        if (vencedor == 0 && maquina.getCount() > 1) {
            maquina.setState(maquina.getVencedorState());
        } else {
            maquina.setState(maquina.getVendidoState());
        }
    }

    @Override
    public void entregar() {
        System.out.println("Você precisa girar a alavanca primeiro.");
    }
}