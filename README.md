# Game-Stop


# Jogo STOP em Java

## 🎯 Objetivo
Desenvolver um jogo de STOP (também conhecido como Adedonha) utilizando a linguagem Java, com estrutura orientada a objetos e foco em organização modular.

---

## 🧱 Estrutura de Classes

### 1. Classe `Main`
Responsável por iniciar e finalizar o jogo.

**Funcionalidades:**
- Pergunta quantos jogadores irão jogar.
- Solicita o nome de cada jogador.
- Pergunta o número de rodadas.
- Permite definir letras proibidas.
- Chama os métodos `startGame()` e `stopGame()` da classe `StopGame`.

---

### 2. Classe `Player`
Representa um jogador no jogo.

**Atributos:**
- `String name`
- `int totalScore`

**Métodos:**
- `addPoints(int pontos)`
- `getTotalScore()`
- `getName()`

---

### 3. Classe `Response`
Representa uma resposta individual de um jogador para uma categoria.

**Atributos:**
- `Category categoria`
- `String resposta`

**Métodos:**
- Getters para categoria e resposta

---

### 4. Classe `Round`
Representa uma rodada do jogo.

**Atributos:**
- `char letraSorteada`
- `Map<Player, List<Response>> respostasJogadores`

**Métodos:**
- `addResponses(Player, List<Response>)`
- `getResponsesForPlayer(Player)`
- `getLetraSorteada()`

---

### 5. Enum `Category`
Enumera todas as categorias do jogo. 

**Exemplo:**
- `NOME`, `ANIMAL`, `CIDADE`, `COR`, `COMIDA`

---

### 6. Classe `ResponseValidator`
Responsável por validar as respostas de todos os jogadores de uma rodada.

**Responsabilidades:**
- Verificar se as respostas começam com a letra sorteada.
- Verificar se as respostas são duplicadas.
- Criar mapa de frequências para facilitar a pontuação.

**Estrutura usada:**
```java
Map<Category, Map<String, Integer>> respostasPorCategoria;
```

---

### 7. Classe `StopGame`
Classe principal que gerencia o funcionamento do jogo.

**Atributos:**
- `List<Player> players`
- `List<Round> rounds`
- `List<Category> categories`
- `Set<Character> letrasProibidas`

**Métodos:**
- `startRound()`
- `calculatePoints(Round)`
- `showScores()`
- `addLetraProibida(char)`
- `sortearLetra()`

---

## 🧮 Regras de Pontuação
- 10 pontos: resposta é única.
- 5 pontos: resposta é repetida.
- 0 pontos: resposta errada ou vazia.

---

## ✅ Funcionalidades Implementadas
- [x] Escolher quantidade de jogadores
- [x] Escolher quantidade de rodadas
- [x] Definir letras proibidas
- [x] Sortear letras válidas
- [x] Validar se respostas começam com a letra
- [x] Detectar respostas duplicadas
- [x] Atribuir pontuação
- [x] Mostrar ranking final

---

## 🚀 Possíveis Expansões Futuras
- Salvar ranking em arquivo `.txt`
- Criar interface gráfica com JavaFX
- Implementar sistema de STOP competitivo (quem digita STOP primeiro)
- Adicionar timer por rodada
- Modo online ou multiplayer em rede

---

## 📝 Observação Final
Este projeto foi desenvolvido com foco educacional, para praticar orientação a objetos e lógica em Java. Está estruturado para facilitar expansões e manutenção.

