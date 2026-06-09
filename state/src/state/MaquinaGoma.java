package state;

public class MaquinaGoma {
    private State semMoedaState;
    private State comMoedaState;
    private State vendidoState;
    private State esgotadoState;
    private State vencedorState;

    private State state;
    private int count = 0;

    public MaquinaGoma(int quantidade) {
        semMoedaState = new SemMoedaState(this);
        comMoedaState = new ComMoedaState(this);
        vendidoState = new VendidoState(this);
        esgotadoState = new EsgotadoState(this);
        vencedorState = new VencedorState(this);

        this.count = quantidade;
        if (quantidade > 0) {
            state = semMoedaState;
        } else {
            state = esgotadoState;
        }
    }

    public void inserirMoeda() {
        state.inserirMoeda();
    }

    public void ejectarMoeda() {
        state.ejectarMoeda();
    }

    public void acionarAlavanca() {
        state.acionarAlavanca();
        state.entregar();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void liberarGoma() {
        System.out.println("Uma goma está saindo...");
        if (count > 0) {
            count--;
        }
        System.out.println("Gomas restantes: " + count);
    }

    public int getCount() {
        return count;
    }

    // Getters para os estados
    public State getSemMoedaState() { 
        return semMoedaState; 
    }
    
    public State getComMoedaState() { 
        return comMoedaState; 
    }
    
    public State getVendidoState() { 
        return vendidoState; 
    }
    
    public State getEsgotadoState() { 
        return esgotadoState; 
    }
    
    public State getVencedorState() { 
        return vencedorState; 
    }

    // Método para mostrar o nome do estado atual
    public String getEstadoNome() {
        if (state == semMoedaState) {
            return "SEM MOEDA - Aguardando moeda";
        } else if (state == comMoedaState) {
            return "COM MOEDA - Moeda inserida, gire a alavanca!";
        } else if (state == vendidoState) {
            return "VENDIDO - Entregando goma...";
        } else if (state == esgotadoState) {
            return "ESGOTADO - Sem gomas disponíveis!";
        } else if (state == vencedorState) {
            return "VENCEDOR - Você ganhou uma goma extra!";
        }
        return "Estado desconhecido";
    }
}