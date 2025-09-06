# Produtor e Consumidor

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

# Desafio do Professor

**Implemente um programa que simule o problema Produtor Consumidor**

- Uma Thread Produtora deve adicionar números aleatórios a uma lista
  compartilhada.

- Uma Thread Consumidora deve remover elementos dessa lista e exibilos no console.
  Use synchronized para garantir que:
- O produtor não insira mais de 5 elementos na lista (capacidade
  máxima).
- O consumidor não tente remover elementos de uma lista vazia.

# Minha Solução

para esse problema eu utilizei duas classes, uma Produtora e uma Consumidora, onde ambas no seu construtor usaram um recurso compartilhado em comum, uma lista de inteiros chamada buffer, onde eu setei que poderia ter apenas 5 itens por buffer.

## Classe Produtora

nessa classe verificamos se o tamanho do buffer, após isso adicionamos um produto, e no final revemos se o buffer ainda pode-se adicionar mais produtos, caso não possa notificamos a classe consumidora com um **notifyAll()** avisando que eles já podem consumir.
```java
      if(buffer.size()<5){

        buffer.add(gerarNumeroAleatorio());

       }else{
                System.out.println("buffer cheio");
        }
   }while(buffer.size() < 5);
            //notifica a consumidora que o produto foi produzido
           synchronized (buffer) {
               buffer.notifyAll();
           }
    
```
## Classe consumidora

Na consumidora esperamos o aviso da classe produtora para que possamos consumir, assim verificando se o buffer é maior que 0 e só deixando de consumir quando ele deixar de ser maior que zero.
```java
//espera o produtor produzir
            synchronized (buffer) {
                buffer.wait();
                //consome os produtos
                while (buffer.size() > 0) {
                    if (buffer.size() > 0) {

                        System.out.println("consumindo o produto " + buffer.get(0));
                        buffer.remove(0);
                    }
                }
            }
```