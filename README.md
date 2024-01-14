# Pokedex-SOLID

Imp

---

## Getting Started

These instructions will help you set up and run the project on your local machine.

### Prerequisites

Make sure you have the following installed on your machine:

- Java 17.0.8
- Gradle 8.2.1

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/AXimenaGaleano/Pokedex-SOLID.git
    ```

2. Navigate to the project directory:

    ```bash
    cd Pokedex-SOLID
    ```

3. Build the project:

    ```bash
    ./gradlew build
    ```

---

## Usage

### Run the Application

To run the web API:

```bash
./gradlew run --args="<pokeID> -s web"
```

To run the API with different output formats:

```bash
./gradlew run --args="<pokeID> -s web -f html"
./gradlew run --args="<pokeID> -s web -f csv"
./gradlew run --args="<pokeID> -s web -f text"
```

To run locally with different output formats:

```bash
./gradlew run --args="<pokeID> -s local -f html"
./gradlew run --args="<pokeID> -s local -f csv"
./gradlew run --args="<pokeID> -s local -f text"
```

### Run Tests

Execute the following command to run tests:

```bash
./gradlew test
```
---
