# 📘 Documentation du Projet App_Web-Spring_MVC

Ce document fournit une explication détaillée de l'architecture du projet, du rôle de chaque fichier, des annotations utilisées et des bibliothèques intégrées.

---

## 🏗️ Architecture du Projet

Ce projet est une application web basée sur l'architecture **MVC (Modèle-Vue-Contrôleur)** utilisant le framework **Spring Boot**.

*   **Modèle (Model) :** Représente les données et la logique métier (Entités JPA, Repository).
*   **Vue (View) :** L'interface utilisateur (Pages HTML avec Thymeleaf).
*   **Contrôleur (Controller) :** Gère les requêtes des utilisateurs et fait le lien entre le Modèle et la Vue.

---

## 📂 Structure des Fichiers et Rôles

### 1. Configuration et Démarrage
*   **`pom.xml` :** Le fichier de configuration de Maven. Il liste toutes les dépendances (bibliothèques) du projet, la version de Java, et les plugins de build.
*   **`AppWebSpringMvcApplication.java` :** Le point d'entrée de l'application. La méthode `main` lance le serveur Tomcat embarqué et démarre Spring Boot.

### 2. Couche Modèle (Data Layer)
*   **`src/main/java/net/soufiane/entities/Product.java` :**
    *   C'est une classe **Entité JPA**. Elle représente la table `Product` dans la base de données.
    *   Chaque instance de cette classe correspond à une ligne dans la table.
    *   Elle contient les champs : `id`, `name`, `price`, `quantity`.
*   **`src/main/java/net/soufiane/repository/ProductRepository.java` :**
    *   C'est une **Interface** qui étend `JpaRepository`.
    *   Elle permet d'interagir avec la base de données sans écrire de SQL (méthodes `save`, `findAll`, `deleteById`, etc.).
    *   Nous y avons ajouté `findByNameContainingIgnoreCase` pour la recherche insensible à la casse.

### 3. Couche Web (Controller Layer)
*   **`src/main/java/net/soufiane/web/ProductController.java` :**
    *   C'est le **Contrôleur**. Il intercepte les requêtes HTTP (URL) venant du navigateur.
    *   Il appelle le Repository pour récupérer ou modifier les données.
    *   Il choisit quelle vue (fichier HTML) afficher et lui transmet les données via l'objet `Model`.
    *   Exemple : La méthode `index` gère l'affichage de la liste des produits avec pagination.

### 4. Couche Sécurité
*   **`src/main/java/net/soufiane/security/SecurityConfig.java` :**
    *   Configure la sécurité de l'application avec **Spring Security**.
    *   Définit les utilisateurs en mémoire (`user`, `admin`).
    *   Définit les règles d'accès (qui a le droit de voir quelle page).
    *   Configure le formulaire de connexion.

### 5. Couche Vue (Templates Thymeleaf)
*   **`src/main/resources/templates/layout.html` :** Le gabarit principal (master page). Il contient l'en-tête, le pied de page et les liens CSS/JS communs. Les autres pages s'insèrent dedans.
*   **`products.html` :** Affiche la liste des produits, la barre de recherche et la pagination.
*   **`formProduct.html` :** Le formulaire pour ajouter un nouveau produit.
*   **`editProduct.html` :** Le formulaire pour modifier un produit existant.
*   **`detailsProduct.html` :** Affiche les détails d'un produit spécifique.
*   **`notAuthorized.html` :** Page d'erreur affichée si un utilisateur tente d'accéder à une ressource interdite (Erreur 403).

---

## 🏷️ Les Annotations Expliquées

Les annotations (commençant par `@`) sont des métadonnées qui indiquent à Spring comment traiter les classes et les méthodes.

### JPA (Base de données)
*   **`@Entity` :** Indique que la classe est une entité JPA mappée à une table de base de données.
*   **`@Id` :** Indique que le champ est la clé primaire.
*   **`@GeneratedValue` :** Indique que la valeur de l'ID est générée automatiquement (auto-incrément).

### Validation (Contraintes)
*   **`@NotEmpty` :** Le champ ne doit pas être vide (ex: nom du produit).
*   **`@Size(min=4, max=20)` :** La taille de la chaîne doit être comprise entre 4 et 20 caractères.
*   **`@DecimalMin("100")` :** La valeur numérique doit être supérieure ou égale à 100.

### Lombok (Génération de code)
*   **`@Data` :** Génère automatiquement les Getters, Setters, `toString`, `equals`, et `hashCode`.
*   **`@NoArgsConstructor` :** Génère un constructeur sans arguments.
*   **`@AllArgsConstructor` :** Génère un constructeur avec tous les arguments.
*   **`@Builder` :** Permet de créer des objets avec le pattern Builder.

### Spring MVC & Core
*   **`@Controller` :** Indique que la classe est un contrôleur Web.
*   **`@GetMapping("/chemin")` :** Mappe les requêtes HTTP GET sur une méthode.
*   **`@PostMapping("/chemin")` :** Mappe les requêtes HTTP POST (soumission de formulaire) sur une méthode.
*   **`@RequestParam` :** Récupère les paramètres de l'URL (ex: `?page=1&keyword=hp`).
*   **`@Valid` :** Active la validation des données du formulaire (vérifie `@NotEmpty`, etc.).
*   **`@Configuration` :** Indique une classe de configuration Spring.
*   **`@Bean` :** Indique une méthode qui produit un objet géré par Spring (ex: `PasswordEncoder`).

---

## 📚 Les Bibliothèques (Libraries)

Voici les principales dépendances utilisées dans le `pom.xml` :

1.  **Spring Boot Starter Web :** Pour créer des applications web, inclut le serveur Tomcat et Spring MVC.
2.  **Spring Boot Starter Data JPA :** Pour l'accès aux données avec Hibernate et JPA.
3.  **Spring Boot Starter Security :** Pour l'authentification et les autorisations.
4.  **Spring Boot Starter Thymeleaf :** Le moteur de template pour générer les pages HTML dynamiques.
5.  **Spring Boot Starter Validation :** Pour la validation des formulaires (Hibernate Validator).
6.  **H2 Database :** Une base de données en mémoire, très rapide pour le développement et les tests.
7.  **MySQL Connector :** Le pilote pour se connecter à une vraie base de données MySQL (pour la production).
8.  **Lombok :** Une bibliothèque qui réduit le code "boilerplate" (getters/setters) via des annotations.
9.  **Bootstrap 5 :** Framework CSS pour le design responsive et les composants UI.
10. **Webjars :** Permet d'inclure des bibliothèques client (comme Bootstrap) via Maven.
11. **SweetAlert2 :** Bibliothèque JavaScript pour des boîtes de dialogue (alertes) esthétiques.
