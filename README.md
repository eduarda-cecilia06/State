```markdown
# Padrão de Projeto Comportamental: State

Projeto de estudo para apresentar uma implementação do padrão de projeto **State** utilizando Java.  

---

## Sobre o padrão State

O **State** é um padrão de projeto comportamental que permite que um objeto altere seu comportamento quando seu estado interno muda. O objeto parecerá ter mudado de classe.

O sistema apresentado simula uma **Máquina de Gomas** com um menu interativo onde o usuário pode:

- Inserir moeda
- Devolver moeda
- Girar alavanca
- Ver estado atual
- Ver gomas restantes

---

## Demonstração

```
==================================================
    MÁQUINA DE GOMAS - PADRÃO STATE 
==================================================

 Quantas gomas deseja colocar na máquina? 3

 Máquina inicializada com 3 gomas!
 Estado atual: SEM MOEDA - Aguardando moeda

=============================================
              MENU INTERATIVO
=============================================
 1  - Inserir moeda
 2️  - Devolver moeda
 3️  - Girar alavanca
 4️  - Ver estado atual
 5️  - Ver gomas restantes
 0️  - Sair
=============================================
 Escolha: 1

--- INSERIR MOEDA ---
Moeda inserida! Agora você pode girar a alavanca.

Escolha: 3

--- GIRAR ALAVANCA ---
 Você girou a alavanca...
 Uma goma está saindo...
 Gomas restantes: 2

 Escolha: 0

 Saindo... Volte sempre!
```

---

### Problema que resolve

Sem o padrão State, você teria um código assim:

```java
if (estado.equals("SEM_MOEDA")) {
    // comportamento para quando não tem moeda
} else if (estado.equals("COM_MOEDA")) {
    // comportamento para quando tem moeda
} else if (estado.equals("VENDIDO")) {
    // comportamento para quando foi vendido
} else if (estado.equals("ESGOTADO")) {
    // comportamento para quando está esgotado
}
```

Isso gera:
- Código difícil de manter
- Alto acoplamento
- Dificuldade para adicionar novos estados

### Solução com State

Cada estado é uma classe separada que implementa a mesma interface. O contexto (máquina de gomas) delega as chamadas para o estado atual, que decide o comportamento e as transições.

---

## Estrutura do Projeto

```
state/
└── src/
    ├── main/
    │   └── Main.java              (Classe principal com menu interativo)
    │
    ├── state/
    │   ├── State.java             (Interface - contrato dos estados)
    │   ├── MaquinaGoma.java       (Contexto - mantém o estado atual)
    │   ├── SemMoedaState.java     (Estado: sem moeda)
    │   ├── ComMoedaState.java     (Estado: com moeda)
    │   ├── VendidoState.java      (Estado: venda realizada)
    │   ├── EsgotadoState.java     (Estado: sem gomas)
    │   └── VencedorState.java     (Estado: ganhou goma extra - 10% chance)
    │
    └── util/
        └── TratarErros.java  
```

---

## Participantes do Padrão

| Classe | Papel | Descrição |
|--------|-------|-----------|
| `MaquinaGoma` | **Contexto** | Mantém o estado atual e delega as ações para ele |
| `State` | **Interface** | Define o contrato que todos os estados devem seguir |
| `SemMoedaState` | **Estado Concreto** | Comportamento quando não há moeda inserida |
| `ComMoedaState` | **Estado Concreto** | Comportamento quando há moeda inserida |
| `VendidoState` | **Estado Concreto** | Comportamento após girar a alavanca |
| `EsgotadoState` | **Estado Concreto** | Comportamento quando não há gomas |
| `VencedorState` | **Estado Concreto** | Comportamento especial com prêmio extra (10% de chance) |

---

## .✦ Diagrama de Estados

```
                    ┌─────────────────────────────────────┐
                    │                                     │
                    ▼                                     │
┌──────────────┐  inserir  ┌──────────────┐  acionar  ┌──────────────┐
│ Sem Moeda    │ ────────► │ Com Moeda    │ ────────► │ Vendido      │
│              │           │              │           │              │
└──────────────┘           └──────────────┘           └──────┬───────┘
       ▲                          │                          │
       │                          │ ejectar                  │ entregar
       │                          ▼                          ▼
       │                    ┌──────────────┐           ┌──────────────┐
       └────────────────────┤ Sem Moeda    │◄──────────┤ Esgotado     │
                            │              │           │              │
                            └──────────────┘           └──────────────┘
                                    ▲
                                    │ (10% de chance)
                                    │
                              ┌──────────────┐
                              │ Vencedor     │
                              │ (ganha extra)│
                              └──────────────┘
```

---

## Funcionamento

1. O programa inicia com um menu interativo
2. O usuário escolhe quantas gomas quer colocar na máquina
3. O usuário escolhe ações no menu:
   - **Inserir moeda** → dependendo do estado, pode aceitar ou recusar
   - **Devolver moeda** → devolve a moeda se houver uma inserida
   - **Girar alavanca** → tenta comprar uma goma
   - **Ver estado atual** → mostra em qual estado a máquina está
   - **Ver gomas restantes** → mostra quantas gomas ainda têm
4. A máquina muda de estado automaticamente conforme as ações
5. O programa só sai quando o usuário escolhe a opção 0

---

## Benefícios Obtidos

| Benefício | Descrição |
|-----------|-----------|
| **Separação de responsabilidades** | Cada estado gerencia seu próprio comportamento |
| **Eliminação de condicionais** | Sem if/else ou switch gigantes |
| **Fácil extensão** | Adicionar um novo estado não quebra os existentes |
| **Baixo acoplamento** | Contexto só conhece a interface State |
| **Open/Closed Principle** | Aberto para extensão, fechado para modificação |
| **Código mais limpo** | Cada estado é pequeno e focado |

---

## Limitações (Trade-offs)

| Limitação | Explicação |
|-----------|------------|
| **Aumento de classes** | Cada estado vira uma classe (pode ser overkill para estados simples) |
| **Contexto e estado acoplados** | Estados precisam conhecer o contexto para mudar de estado |
| **Complexidade inicial** | Maior curva de aprendizado que condicionais simples |

### Quando NÃO usar State

- O objeto tem apenas 2 ou 3 estados muito simples
- Os estados raramente mudam durante a execução
- A lógica de transição é trivial e não tende a crescer

---

## Como Executar

### Pré-requisitos
- Java JDK 17 ou superior
- Terminal ou IDE

### Execução via terminal

```bash
# Entre na pasta do projeto
cd ~/OneDrive/Área\ de\ Trabalho/State/state

# Compile todos os arquivos
javac -d . src/main/Main.java src/state/*.java src/util/*.java

# Execute o programa
java main.Main
```

### Execução via script (Windows)

```bash
./run.bat
```

### Execução via IDE (VSCode/IntelliJ/Eclipse)

1. Abra o projeto na sua IDE
2. Navegue até `src/main/Main.java`
3. Clique em "Run" ou pressione `F5`

---

