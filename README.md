# 🐾 AnimalCompositeJava

A small **Java console application** demonstrating the **Composite design pattern** using an animal hierarchy example.

Each animal has its own behavior (movement, communication, and feeding), and the `AnimalComposite` class allows grouping multiple animals together and displaying information about them as a single collection.

---

## 🧩 Project Overview

This project illustrates the **Composite Pattern**, where individual objects (`Leaf` classes) and groups of objects (`Composite`) are treated uniformly.

### Core Components

| Class | Role |
|-------|------|
| `AnimalComponent` | Abstract base class for all animals |
| `AnimalComposite` | Composite that can hold multiple `AnimalComponent` objects |
| `DomesticatedTypeLeaf`, `WildTypeLeaf` | Abstract subclasses for domestic and wild animals |
| `PetSubtypeLeaf`, `AnimalHusbandrySubtypeLeaf`, `PredatorsSubtypeLeaf`, `HerbivoresSubtypeLeaf` | Concrete animal types |
| `Feeding` and subclasses | Strategy pattern for defining how animals feed |
| `FeedingFactory` | Factory that creates feeding strategies |
| `App` | Entry point of the application (contains `main`) |

---

## 🖥️ How to Run

### Requirements
- Java **17** (or higher)
- Any IDE or command line with `javac` and `java`

### Run from Command Line

```bash
cd src
javac App.java
java App
```
Or just run App.java directly from your IDE (IntelliJ IDEA / VS Code).

## 🐾 Example Output

```
AnimalComponent{
    name='Cow'
    moveMethod='They move on all four legs'
    communicateMethod='Communicate with each other using various sounds such as mooing.'
    feeding=Cows usually eat grass, hay, and grain
}
AnimalComponent{
    name='Cat'
    moveMethod='They move on all four legs and can jump high'
    communicateMethod='Cats communicate with meows, purrs, and body language.'
    feeding=Cats are obligate carnivores and require meat-based diets.
}
AnimalComponent{
    name='Lion'
    moveMethod='They move on all four legs and can run up to 50 mph'
    communicateMethod='Lions communicate with roars and body language.'
    feeding=Lions are apex predators and require meat-based diets.
}
AnimalComponent{
    name='Rabbit'
    moveMethod='They move by hopping'
    communicateMethod='Rabbits communicate through sounds and gestures.'
    feeding=Rabbits usually eat grass, hay, and vegetables
}
```

## 🧠 Design Patterns Used

### 🧩 Composite Pattern  
> *Treats individual objects and groups of objects uniformly.*

This pattern allows both single animals and groups of animals to be processed in the same way.

**Structure:**
- **`AnimalComponent`** — base abstraction for all animals  
- **`AnimalComposite`** — container for multiple `AnimalComponent` objects  
- **Leaf classes** — specific animal types (`Cat`, `Cow`, `Lion`, `Rabbit`, etc.)

```text
             ┌───────────────────────┐
             │   AnimalComponent     │◄───────────┐
             └───────────────────────┘            │
                         ▲                        │
        ┌────────────────┴────────────────┐       │
        │                                 │       │
┌────────────────────┐        ┌────────────────────┐
│  AnimalComposite   │        │   Leaf Classes     │
│ (contains children)│        │ (Cat, Cow, etc.)   │
└────────────────────┘        └────────────────────┘
```

### 🏭 Factory Pattern

> *Encapsulates object creation logic for feeding behaviors.*

Implemented in FeedingFactory

Creates feeding strategies dynamically (HerbivoresFeeding, PetFeeding, etc.)

Keeps creation logic separate from main program flow
```text
FeedingFactory → returns Feeding implementation
   ├─ HerbivoresFeeding
   ├─ LivestockFeeding
   ├─ PetFeeding
   └─ PredatorsFeeding
```

Конечно 😎 — вот красиво оформленный и структурированный кусок твоего README, в стиле профессиональных GitHub-проектов.
Можешь просто заменить соответствующую часть в `README.md` этим блоком 👇

---

````markdown
## 🧠 Design Patterns Used

### 🧩 Composite Pattern  
> *Treats individual objects and groups of objects uniformly.*

This pattern allows both single animals and groups of animals to be processed in the same way.

**Structure:**
- **`AnimalComponent`** — base abstraction for all animals  
- **`AnimalComposite`** — container for multiple `AnimalComponent` objects  
- **Leaf classes** — specific animal types (`Cat`, `Cow`, `Lion`, `Rabbit`, etc.)

```text
             ┌───────────────────────┐
             │   AnimalComponent     │◄───────────┐
             └───────────────────────┘            │
                         ▲                        │
        ┌────────────────┴────────────────┐       │
        │                                 │       │
┌────────────────────┐        ┌────────────────────┐
│  AnimalComposite   │        │   Leaf Classes     │
│ (contains children)│        │ (Cat, Cow, etc.)   │
└────────────────────┘        └────────────────────┘
````

---

### 🏭 Factory Pattern

> *Encapsulates object creation logic for feeding behaviors.*

* Implemented in **`FeedingFactory`**
* Creates feeding strategies dynamically (`HerbivoresFeeding`, `PetFeeding`, etc.)
* Keeps creation logic separate from main program flow

```text
FeedingFactory → returns Feeding implementation
   ├─ HerbivoresFeeding
   ├─ LivestockFeeding
   ├─ PetFeeding
   └─ PredatorsFeeding
```

---

## 👤 Author

**Alex Makovka**
🔗 [GitHub Profile](https://github.com/AlexMakovka)
