# Contador de Dias - Dias Juntos

Projeto Spring Boot minimalista que conta os dias de forma contínua e armazena em arquivo `.txt`. Interface estilizada como relógio digital para visualizar o contador.

## 🎯 Recursos

- **Contador Automático**: Incrementa automaticamente a cada meia-noite
- **Armazenamento Persistente**: Dados salvos em `numero.txt`
- **Interface Minimalista**: Design similar a um relógio de parede
- **Backend REST**: API simples que retorna o contador
- **Responsivo**: Funciona em desktop e mobile

---

## 🚀 Começar Rápido

### Pré-requisitos

- Java 21+
- Maven 3.6+

### Executar com Maven Spring Boot

```bash
cd diasjuntos
mvn spring-boot:run
```

A aplicação inicia em `http://localhost:8080`

**Isso é tudo!** A aplicação está pronta para usar.

---

## 📦 Outros Modos de Execução

### 1. Compilar e Executar JAR

```bash
# Compilar
mvn clean package

# Executar
java -jar target/diasjuntos-0.0.1-SNAPSHOT.jar
```

### 2. Docker

```bash
# Build da imagem
docker build -t diasjuntos:latest .

# Executar container
docker run -p 8080:8080 diasjuntos:latest
```

### 3. Deploy Online (Railway, Render, etc)

Conecte seu repositório GitHub a uma plataforma de cloud:

- **Railway**: `railway.app`
- **Render**: `render.com`

Ambas detectam Spring Boot automaticamente.

---

## 📁 Estrutura do Projeto

```
diasjuntos/
├── src/
│   ├── main/
│   │   ├── java/com/projeto/diasjuntos/
│   │   │   ├── DiasjuntosApplication.java       (Entry point)
│   │   │   ├── NumeroController.java            (REST API)
│   │   │   └── NumeroService.java               (Lógica do contador)
│   │   └── resources/static/
│   │       ├── index.html                        (Interface)
│   │       ├── style.css                         (Estilo minimalista)
│   │       └── script.js                         (JavaScript frontend)
│   └── test/
├── pom.xml                                       (Dependências Maven)
├── numero.txt                                    (Arquivo de armazenamento)
└── README.md                                     (Este arquivo)
```

---

## 🔌 API

### Endpoint

```
GET /api/numero
```

**Resposta:**

```json
324
```

Retorna o número atual de dias em formato inteiro.

---

## ⚙️ Como Funciona

1. **Inicialização**: NumeroService lê `numero.txt` ou inicia com valor padrão (129)
2. **API**: Endpoint `/api/numero` retorna o valor actual
3. **Frontend**: Faz fetch à API e exibe o contador em formato de relógio
4. **Atualização**: Todo dia à meia-noite (`0 0 0 * * *`), o contador é incrementado e salvo

---

## 🎨 Interface

A interface exibe um relógio minimalista com:

- Círculo simples com borda preta
- Label "DIAS" acima
- Número grande centralizado
- Design responsivo para mobile

---

## 📝 Configuração

Para alterar o valor inicial do contador, edite `NumeroService.java`:

```java
numeroAtual = 129;  // Mude este valor
```

---

## 🔧 Desenvolvimento

Editar código e a aplicação recarrega automaticamente:

```bash
mvn spring-boot:run
```

Spring Boot DevTools está habilitado para auto-reload.

---

## 📊 Logs

Ver output da aplicação:

```bash
mvn spring-boot:run
```

Se rodando com JAR:

```bash
java -jar diasjuntos.jar
```

---

## 🐛 Troubleshooting

**Porta 8080 já em uso?**

```bash
mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8081"
```

**numero.txt não encontrado?**
Será criado automaticamente com valor padrão na primeira execução.

**Contador não incrementa à meia-noite?**

- Verifique que `@EnableScheduling` está em `DiasjuntosApplication.java`
- Certifique-se que a aplicação está rodando continuamente

---

## 📦 Build para Produção

```bash
# Compilar versão otimizada
mvn clean package -DskipTests

# JAR criado em: target/diasjuntos-0.0.1-SNAPSHOT.jar
```

---

## 🚢 Deploy

### Railway.app (Recomendado)

1. Conecte seu GitHub
2. Railway detecta Spring Boot automaticamente
3. Deploy realizado em segundos

### VPS com Systemd

```bash
# Transferir JAR para servidor
scp target/diasjuntos-0.0.1-SNAPSHOT.jar user@servidor:/opt/diasjuntos/

# Criar arquivo de serviço systemd
# (ver documentação completa em DEPLOYMENT.md)

# Iniciar
systemctl start diasjuntos
```

---

## 📄 Licença

Projeto pessoal. Sinta-se livre para usar e modificar.

---

## 👨‍💻 Autor

Italo Mendes

---

## ✅ Checklist Rápido

- [x] Java 21 instalado
- [x] Maven instalado
- [x] Clonar/baixar o projeto
- [x] `mvn spring-boot:run`
- [x] Acessar `http://localhost:8080`
- [x] ✨ Pronto!
