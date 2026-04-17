# Android Template : BDD + Réseau + Adaptive UI
## AVRIL 2026

Ce projet est un "moule" pour lancer rapidement des applications Android modernes. Il utilise les dernières technos et suit une architecture robuste pour éviter que le code ne devienne un plat de spaghettis !

## Fonctionnalités Clés

*   **Architecture Clean/MVVM** : Séparation claire des responsabilités.
*   **Injection de dépendances** : Avec **Hilt** pour un code modulaire et testable.
*   **Persistance locale** : **Room** avec support complet des Coroutines.
*   **Réseau** : **Retrofit** + **Kotlinx Serialization** pour parler aux API.
*   **UI Moderne** : 100% **Jetpack Compose** (Material 3).
*   **Adaptatif** : Supporte mobiles, tablettes et pliables via `WindowSizeClass`.
*   **Images** : Chargement fluide avec **Coil 3**.

## Stack Technique

*   **Kotlin 2.3.20** & **Compose BOM 2026.03.01**
*   **AGP :** 9.1.0 / **KSP :** 2.3.5
*   **Hilt :** 2.59.2
*   **Room :** 2.8.4
*   **Retrofit :** 3.0.0

## Structure du Projet (Clean Architecture)

Les principaux packages sont :

```text
app/src/main/java/fr/quinquenaire/templatebddreseauadaptive/
├── data/           # LA SOURCE : Implémentation des Repositories, DAOs, API Services, DTOs.
├── domain/         # LE CERVEAU : Modèles métiers (Data Classes), Interfaces des Repositories, Use Cases.
├── di/             # LE CABLAGE : Modules Hilt pour l'injection.
├── ui/             # LE VISAGE : Screens (Composables), ViewModels, Thème, Composants génériques.
└── util/           # LES OUTILS : Extensions Kotlin, Helpers, formats de date, etc.
```
un fichier .gitkeep est à l'intérieur pour éviter que git ignore les dossiers vides.

> **Note pédagogique :** La couche `domain` ne doit dépendre de rien d'autre. C'est du Kotlin pur. Elle définit *ce que l'app fait* (ex: `GetUserNameUseCase`), alors que `data` définit *comment elle le récupère* (ex: via Retrofit).

## Comment utiliser ce template ?

1.  **Refactoriser le package** : Change `fr.quinquenaire.templatebddreseauadaptive` par ton propre nom dans `build.gradle.kts` (app) et dans les dossiers `java`.
2.  **Config Réseau** : Mets à jour l'URL de base dans tes modules Hilt.
3.  **Config Room** : Crée tes `@Entity` et tes `DAO`, puis mets à jour `AppDatabase`.
4.  **MainActivity** : il n'y a pas de thème dans ce projet. N'oubliez pas de l'ajouter.

## Licence

Libre d'utilisation pour tout projet personnel ou commercial. Enjoy ! 
