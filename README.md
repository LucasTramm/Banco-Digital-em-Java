# 💰 Banco Digital em Java

Projeto simples de **Banco Digital** feito em Java, utilizando conceitos de **Programação Orientada a Objetos (POO)** como **herança, abstração, interfaces e polimorfismo**.

---

## 🚀 Funcionalidades
- Login de usuário (simulado)
- Escolha de tipo de conta:
  - Conta Corrente
  - Conta Poupança
- Operações bancárias:
  - Consultar saldo
  - Depositar
  - Sacar
  - Pagar boletos
  - Logout e retorno ao login
- Estrutura organizada em pacotes (`modelo`, `interfaces`)

---

## 📂 Estrutura do Projeto
src/
└── banco/
├── Main.java # Ponto de entrada
├── modelo/ # Classes de domínio
│ ├── Cliente.java
│ ├── Conta.java
│ ├── ContaCorrente.java
│ └── ContaPoupanca.java
├── interfaces/ # Contratos
│ └── IConta.java

---

🔑 Login de Teste

Usuário: Zezinho

Senha: 1234

Ao logar, o sistema pergunta qual tipo de conta deseja usar e disponibiliza o menu de operações.

---

📖 Aprendizados

Este projeto demonstra:

Uso de interfaces (IConta) para definir comportamentos

Classe abstrata (Conta) para atributos e métodos comuns

Especialização em classes concretas (ContaCorrente e ContaPoupanca)

Estrutura de pacotes para organização de código
