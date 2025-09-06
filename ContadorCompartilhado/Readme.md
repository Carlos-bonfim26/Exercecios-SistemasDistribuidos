# Contador Compartilhado
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

# Desafio do Professor

**Exercício – Contador Compartilhado**

- Implemente um programa em Java onde 5 Threads incrementam
um contador compartilhado.
- Cada Thread deve fazer 100 incrementos.
- O contador é um atributo comum (inteiro).
- Espera-se que ao término da execução, o valor impresso seja 500.

# Minha solução

Apliquei as 5 threads no contador e coloquei no metodo run um ciclo for que incrementa 100 vezes no contador.
```java
   //coloca uma pausa para simular o processamento
            Thread.sleep(10);
            for (int i = 0; i < 100; i++) {
                 // incrementa o contador compartilhado
               ContadorSingleton.getInstancia().addContador();
            }
```

Para que o contador chegue sempre aos 500 eu utilizei o padrão de projeto **Singleton** que aceita apenas uma instância, assim sendo uma "variável global" refinada, e junto com o synchronized é possível fazer que cada thread adicione ao contador de cada vez
```java
 // método sincronizado para incrementar o contador
    public synchronized int addContador() {
        return contador++;
    }

```