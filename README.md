# Tasca S3.01 – Patrons de disseny (Nivell 1)

## Descripció
En aquesta pràctica hem après a identificar i construir programes emprant **patrons de disseny**.  
L’ús de patrons és fonamental per desenvolupar un programari **extensible, reutilitzable i mantenible**.  
En aquest exercici s’ha implementat el **patró Singleton** mitjançant una classe que reprodueix el funcionament del comando `Undo`.

## Estructura del projecte
```
3.1-Patterns-Nivell1/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── undo_command_history/
│   │   │       ├── Main.java
│   │   │       └── Undo.java
│   │   └── resources/
│   └── test/
│       ├── java/
│       │   └── undo_command_history/
│       │       └── UndoTest.java
│       └── resources/
│
├── .gitignore
├── pom.xml
└── README.md
```

## Funcionament

El programa permet interactuar amb l’usuari mitjançant la consola per gestionar un **historial de comandes**:

1. **Afegir una comanda nova**
2. **Eliminar l’última comanda**
3. **Llistar totes les comandes guardades**
0. **Sortir del programa**

### Exemple d’execució

```
MENU:
1. Add command
2. Remove last command
3. List commands
0. Exit
> 1
Please input your command:
> open file.txt
Command successfully added.

MENU:
1. Add command
2. Remove last command
3. List commands
0. Exit
> 1
Please input your command:
> save file.txt
Command successfully added.

MENU:
1. Add command
2. Remove last command
3. List commands
0. Exit
> 3
These are the existing commands:
open file.txt
save file.txt


```

## Patró utilitzat: Singleton

La classe `Undo` implementa el **patró Singleton**, que garanteix que només hi hagi **una instància única** accessible globalment durant l’execució del programa.

### Característiques clau:
- **Constructor privat** per evitar la creació d’instàncies externes.  
- **Mètode estàtic `getInstance()`** que retorna sempre la mateixa instància.  
- Mètodes públics per **afegir, eliminar i llistar** comandes.

## Requisits tècnics
- **Java 17** o superior.  
- Projecte **Maven** amb dependències configurades al `pom.xml`.  
- Entorn recomanat: **IntelliJ IDEA** o **Eclipse**.  

## Execució
Des de la línia de comandes:

```bash
cd 3.1-Patterns-Nivell1
mvn compile
mvn exec:java -Dexec.mainClass="undo_command_history.Main"
```

## Tests
Els tests (`UndoTest.java`) comproven:
- Que el Singleton sempre retorna la mateixa instància.  
- Que es poden afegir i eliminar comandes correctament.  
- Que el llistat de comandes reflecteix l’estat esperat.
