package gameReading.checkers;

import java.util.Arrays;
import java.util.List;

public class PlantsAnimalsKeyWords {
    
    public static List <String> getAnimalsKeyWords() {
        return Arrays.asList(
                        // Mammals
                        "canidae",       // Dogs
                        "felidae",       // Cats
                        "ursidae",       // Bears
                        "equidae",       // Horses
                        "bovidae",       // Cows, Bison
                        "muridae",       // Rodents
                        "hominidae",     // Apes, humans
                        "cercopithecidae", // Old World monkeys
                        "elephantidae",  // Elephants
                        "delphinidae",   // Dolphins
                        "balaenopteridae", // Whales

                        // Birds
                        "accipitridae",  // Hawks, Eagles
                        "strigidae",     // Owls
                        "anatidae",      // Ducks, Geese
                        "corvidae",      // Crows, Ravens
                        "passeridae",    // Sparrows
                        "columbidae",    // Pigeons, Doves
                        "trochilidae",   // Hummingbirds

                        // Reptiles
                        "colubridae",    // Snakes
                        "viperidae",     // Vipers
                        "elapidae",      // Cobras, Coral snakes
                        "crocodylidae",  // Crocodiles
                        "testudinidae",  // Tortoises
                        "cheloniidae",   // Sea turtles
                        "lacertidae",    // Lizards
                        "agamidae",      // Lizards
                        "gekkoidae",     // Geckos

                        // Amphibians
                        "ranidae",       // Frogs
                        "bufonidae",     // Toads
                        "salamandridae", // Salamanders & Newts
                        "caeciliidae",   // Caecilians

                        // Fish
                        "salmonidae",    // Salmon, Trout
                        "scombridae",    // Tuna
                        "carcharhinidae",// Sharks
                        "lamnidae",      // Sharks
                        "cyprinidae",    // Goldfish, Carp
                        "ictaluridae",   // Catfish
                        "siluridae",     // Catfish

                        // Insects
                        "nymphalidae",   // Butterflies
                        "papilionidae",  // Butterflies
                        "apidae",        // Bees
                        "vespidae",      // Wasps
                        "carabidae",     // Beetles
                        "scarabaeidae",  // Beetles
                        "formicidae",    // Ants
                        "muscidae",      // Flies
                        "calliphoridae", // Flies

                        // Other invertebrates
                        "octopodidae",   // Octopus
                        "loliginidae",   // Squid
                        "portunidae",    // Crabs
                        "grapsidae",     // Crabs
                        "araneidae",     // Spiders
                        "lycosidae",     // Spiders
                        "buthidae",     // Scorpions
                        //common animal descriptions
                        "cat", "dog", "bird", "horse", "cow", "sheep", "pig",
                        "elephant", "tiger", "lion", "bear", "whale", "dolphin",
                        "shark", "snake", "lizard", "frog", "toad", "spider",
                        "ant", "bee", "wasp", "butterfly", "crab", "octopus",
                        "squid", "fish", "monkey", "giraffe", "zebra", "deer", "rabbit", "mouse", "rat"
                    );
    }

    public static List <String> getPlantsKeyWords() {
        return Arrays.asList(
            "rosaceae", "fabaceae", "poaceae", "asteraceae", "lamiaceae",
            "orchidaceae", "solanaceae", "brassicaceae", "apiaceae",
            "pinaceae", "cupressaceae", "ginkgoaceae", "cycadaceae",
            "pteridaceae", "polypodiaceae", "equisetaceae",
            "bryaceae", "sphagnaceae","plant", "tree", "flower", "shrub", "herb", "grass", "vine"
        );
    }

}
