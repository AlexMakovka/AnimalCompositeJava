public class App {

    // ====== Абстрактные и базовые классы ======
    static abstract class AnimalComponent {
        String name;
        protected String moveMethod;
        protected String communicateMethod;
        protected Feeding feeding;

        protected abstract void move();
        protected abstract void communicate();

        protected void eat() {
            feeding.feed();
        }

        @Override
        public String toString() {
            return "AnimalComponent{\n" +
                    "\tname='" + name + '\'' + '\n' +
                    "\tmoveMethod='" + moveMethod + '\'' + '\n' +
                    "\tcommunicateMethod='" + communicateMethod + '\'' + '\n' +
                    "\tfeeding=" + feeding.feed() + '\n' +
                    '}';
        }
    }

    static class AnimalComposite extends AnimalComponent {
        java.util.List<AnimalComponent> children = new java.util.ArrayList<>();

        public AnimalComposite() {}

        public AnimalComposite(AnimalComponent[] animalComponents) {
            add(animalComponents);
        }

        public void add(AnimalComponent animalComponent) {
            children.add(animalComponent);
        }

        public void add(AnimalComponent[] animalComponents) {
            children.addAll(java.util.Arrays.asList(animalComponents));
        }

        public void getAllInfo() {
            for (AnimalComponent animal : children) {
                System.out.println(animal.toString());
            }
        }

        @Override
        public void move() {
            for (AnimalComponent component : children) {
                component.move();
            }
        }

        @Override
        public void communicate() {
            for (AnimalComponent component : children) {
                component.communicate();
            }
        }

        @Override
        public void eat() {
            for (AnimalComponent component : children) {
                component.eat();
            }
        }
    }

    static abstract class DomesticatedTypeLeaf extends AnimalComponent {
        protected boolean isVaccination;
    }

    static abstract class WildTypeLeaf extends AnimalComponent {
        protected boolean isPackAnimal;
    }

    // ====== Разные типы животных ======
    static class AnimalHusbandrySubtypeLeaf extends DomesticatedTypeLeaf {
        AnimalHusbandrySubtypeLeaf(String name, boolean isVaccination, Feeding feeding, String moveMethod, String communicateMethod) {
            this.name = name;
            this.isVaccination = isVaccination;
            this.feeding = feeding;
            this.moveMethod = moveMethod;
            this.communicateMethod = communicateMethod;
        }

        @Override public void move() { System.out.println(moveMethod); }
        @Override public void communicate() { System.out.println(communicateMethod); }
    }

    static class PetSubtypeLeaf extends DomesticatedTypeLeaf {
        PetSubtypeLeaf(String name, boolean isVaccination, Feeding feeding, String moveMethod, String communicateMethod) {
            this.name = name;
            this.isVaccination = isVaccination;
            this.feeding = feeding;
            this.moveMethod = moveMethod;
            this.communicateMethod = communicateMethod;
        }

        @Override public void move() { System.out.println(moveMethod); }
        @Override public void communicate() { System.out.println(communicateMethod); }
    }

    static class PredatorsSubtypeLeaf extends WildTypeLeaf {
        PredatorsSubtypeLeaf(String name, boolean isPackAnimal, Feeding feeding, String moveMethod, String communicateMethod) {
            this.name = name;
            this.isPackAnimal = isPackAnimal;
            this.feeding = feeding;
            this.moveMethod = moveMethod;
            this.communicateMethod = communicateMethod;
        }

        @Override public void move() { System.out.println(moveMethod); }
        @Override public void communicate() { System.out.println(communicateMethod); }
    }

    static class HerbivoresSubtypeLeaf extends WildTypeLeaf {
        HerbivoresSubtypeLeaf(String name, boolean isPackAnimal, Feeding feeding, String moveMethod, String communicateMethod) {
            this.name = name;
            this.isPackAnimal = isPackAnimal;
            this.feeding = feeding;
            this.moveMethod = moveMethod;
            this.communicateMethod = communicateMethod;
        }

        @Override public void move() { System.out.println(moveMethod); }
        @Override public void communicate() { System.out.println(communicateMethod); }
    }

    // ====== Интерфейс и классы кормления ======
    interface Feeding { String feed(); }

    static class PredatorsFeeding implements Feeding {
        private final boolean isHunting;
        private final String huntingProcess;

        public PredatorsFeeding(Builder builder) {
            this.isHunting = builder.isHunting;
            this.huntingProcess = builder.huntingProcess;
        }

        @Override public String feed() { return huntingProcess; }

        static class Builder {
            private boolean isHunting;
            private String huntingProcess = "";

            public Builder isHunting(boolean isHunting) { this.isHunting = isHunting; return this; }
            public Builder huntingProcess(String huntingProcess) {
                if (isHunting) this.huntingProcess = huntingProcess;
                return this;
            }
            public PredatorsFeeding build() { return new PredatorsFeeding(this); }
        }
    }

    static class HerbivoresFeeding implements Feeding {
        private final String method;
        HerbivoresFeeding(String method) { this.method = method; }
        @Override public String feed() { return this.method; }
    }

    static class LivestockFeeding implements Feeding {
        private final String method;
        LivestockFeeding(String method) { this.method = method; }
        @Override public String feed() { return this.method; }
    }

    static class PetFeeding implements Feeding {
        private final String method;
        PetFeeding(String method) { this.method = method; }
        @Override public String feed() { return this.method; }
    }

    static class FeedingFactory {
        static Feeding create(String feeding, String method) {
            return switch (feeding) {
                case "hunting" -> new PredatorsFeeding.Builder().isHunting(true).huntingProcess(method).build();
                case "scavenger" -> new PredatorsFeeding.Builder().isHunting(false).build();
                case "herbivores" -> new HerbivoresFeeding(method);
                case "livestock" -> new LivestockFeeding(method);
                case "pet" -> new PetFeeding(method);
                default -> throw new IllegalArgumentException("Unknown feeding type: " + feeding);
            };
        }
    }

    // ====== Точка входа ======
    public static void main(String[] args) {
        AnimalComposite animalComposite = new AnimalComposite(new AnimalComponent[]{
                new AnimalHusbandrySubtypeLeaf("Cow", true,
                        FeedingFactory.create("herbivores", "Cows usually eat grass, hay, and grain"),
                        "They move on all four legs",
                        "Communicate with each other using various sounds such as mooing."),
                new PetSubtypeLeaf("Cat", true,
                        FeedingFactory.create("pet", "Cats are obligate carnivores and require meat-based diets."),
                        "They move on all four legs and can jump high",
                        "Cats communicate with meows, purrs, and body language."),
                new PredatorsSubtypeLeaf("Lion", true,
                        FeedingFactory.create("hunting", "Lions are apex predators and require meat-based diets."),
                        "They move on all four legs and can run up to 50 mph",
                        "Lions communicate with roars and body language."),
                new HerbivoresSubtypeLeaf("Rabbit", false,
                        FeedingFactory.create("herbivores", "Rabbits usually eat grass, hay, and vegetables"),
                        "They move by hopping",
                        "Rabbits communicate through sounds and gestures.")
        });

        animalComposite.getAllInfo();
    }
}
