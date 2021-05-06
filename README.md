# Christopher Columbus Game

In the Christopher Columbus game, the player tries to bring the Columbus ship to the treasure island by using the arrow keys. But there are several challenges here that make it hard to find a safe path to the treasure island. The below image shows a screenshot of the game.

<img src="https://user-images.githubusercontent.com/45066620/117269040-2d52c700-ae6d-11eb-825c-b2576b45cbcb.jpg" width="460">


# Game Characters


### Christopher Columbus Ship:
<img src="https://user-images.githubusercontent.com/45066620/117269497-8fabc780-ae6d-11eb-866e-4f8586775f59.png" width="50">
It is the player and will be controlled by the arrow key. The goal is to bring it to the treasure island.

### Island:
<img src="https://user-images.githubusercontent.com/45066620/117269524-95a1a880-ae6d-11eb-92cc-361d3157b3c2.png" width="50">
They are empty islands. Columbus's ship will use them to run away from pirates.

### Treasure Island:
<img src="https://user-images.githubusercontent.com/45066620/117269639-b538d100-ae6d-11eb-94b6-a553d2ae1691.png" width="50">
The player wins the game if Columbus's ship touches the beach of Treasure Island.

### Pirate Islands:
<img src="https://user-images.githubusercontent.com/45066620/117269676-be29a280-ae6d-11eb-95fe-0571a7ec6c61.png" width="50">
The player loses the game if Columbus's ship touches the beach of the Pirate island.

### Monster:
<img src="https://user-images.githubusercontent.com/45066620/117269758-cda8eb80-ae6d-11eb-9e95-1da5e433fe97.png" width="50">
They move randomly on the ocean. If accidentally placed at the Columbus ship location, they will break the ship.

### Pirate - Revenge Ship:
<img src="https://user-images.githubusercontent.com/45066620/117269804-d7caea00-ae6d-11eb-86bc-4df048410183.png" width="50">
They are the most dangerous characters in the game. Because they know what it is the location of the Columbus ship and start to chase as soon as the game start.

### Pirate - Adventure Galley Ship:
<img src="https://user-images.githubusercontent.com/45066620/117269841-e0232500-ae6d-11eb-834d-6914fe1aa80b.png" width="50">
They are pirates too but unlike Revenge ship, they do not know where the Columbus ship is, so they are patrolling the ocean randomly until they accidentally see Columbus ship. If they find Columbus ship start to chase it like Revenge ship.

### Whirlpool:
<img src="https://user-images.githubusercontent.com/45066620/117269882-e9ac8d00-ae6d-11eb-96f9-95893eaf57a4.png" width="50">
It is a small whirlpool. If Columbus's ship decides to cross on it will be drowned.

### Crazy Whirlpool:
<img src="https://user-images.githubusercontent.com/45066620/117269919-f29d5e80-ae6d-11eb-91fa-2515716a832a.png" width="50">
It is a giant whirlpool. If Columbus's ship decides to cross on it will be drowned.

# Design Pattern 1 - Singleton:
OceanMap class designed to create the main map of the game by uploading the ocean Image as background and randomly spreading the Islands on the ocean. This class defined based on the Singleton Design Pattern to make sure just one instance will be created and provides easier access to the created instance.
Furthermore, the game has a Restart button, and it is essential to delete and recreate the map object which is the Singleton. So, as shown in the below image, the Clean method was designed to assign null to the created object of the OceanMap.

<img src="https://user-images.githubusercontent.com/45066620/117280097-8293d600-ae77-11eb-9c20-e6741d278d73.png" width="300">


# Design Pattern 2 - Observer:
As it was mentioned above, the Columbus ship moved by the arrow keys. On the other hand, the pirates must move in the appropriate direction that makes them closer to the Columbus ship after each move of the ship. So the Observer Design Pattern was used to notifies, the new location of the Columbus ship to all pirates on the ocean. (It means: they know which arrow key was pressed at the moment).
Based on the below image there are two kinds of classes that are observing the Columbus ship (Revenge ship and Adventure Gally ship). Furthermore, monsters have been defined as the observer but for simplifying, their UML Diagram was not shown below.

<img src="https://user-images.githubusercontent.com/45066620/117280341-bff86380-ae77-11eb-986a-15581c1756f5.png" width="800">


# Design Pattern 3 - Strategy:
Although both types of pirate ships at the game inherited the methods and attributes from the pirate class, their moving behaviors can be independently controlled and change during the game. To aim this goal the strategy design pattern was used. The moving behavior interface designed to make these controls easier.
Adventure Galley ship is patrolling on the ocean until finding Columbus's ship then its behavior will change to chasing. But, Revenge's ship strat to chasing the Columbus ship as soon as the game start.

<img src="https://user-images.githubusercontent.com/45066620/117280610-051c9580-ae78-11eb-9d76-5b944c91aa20.png" width="900">


# Design Pattern 4 - Composite:
It is considered for the users to create monsters and place them in different groups. Each group has a different space for moving on the ocean. for example, their members can move freely on the entire ocean, or their movement can be limited to the upper half or lower half of the ocean. This level of control implemented by the Composite Design Pattern.

<img src="https://user-images.githubusercontent.com/45066620/117280778-3006e980-ae78-11eb-89ec-db800104f5da.png" width="900">


# Design Pattern 5 - Decorator:
There are several whirlpools on the ocean. But by using the Decorator Design Pattern there is an option for the user to modify and create a new whirlpool with a new image and new size. For example, the regular whirlpool (small and blue) will create by the WhirlpoolClass class and the crazy whirlpool (giant and gray) can be created by the WhirlpoolDecoratorCrazy class. Both of these whirlpools are inheriting from Whirlpool interface.

<img src="https://user-images.githubusercontent.com/45066620/117280925-5cbb0100-ae78-11eb-9212-d10e23f9491c.png" width="700">


# Other Features:

1. Implementing JUnit Test for two methods
2. Restart Button
3. Sound Effects
4. Win and Lose Notification
5. Customizable Map 
6. Start Pointer




