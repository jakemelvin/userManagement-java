# User Management API with Spring Boot

API de gestion d'utilisateurs avec authentification JWT et documentation Swagger/OpenAPI.

## 📋 Prérequis

- Java 21
- Maven 3.9+
- PostgreSQL 15+
- IDE (IntelliJ, VSCode, etc.)
- Postman ou curl pour les tests

## 🚀 Installation locale

### 1. Cloner le dépôt
```bash
git clone https://github.com/votre-repo/user-management.git
cd user-management
```

### 2. Configurer la base de données
#### 1. Créer une base PostgreSQL :
```bash
CREATE DATABASE user_management;
```
#### 2. Configurer application.properties :
```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/user_management
spring.datasource.username=postgres
spring.datasource.password=votre_mot_de_passe
```

### 3. Builder et lancer l'application
```bash
mvn clean install
mvn spring-boot:run
```

📚 Documentation des APIs
Swagger UI
Accédez à l'interface interactive :
http://localhost:9001/swagger-ui.html

Swagger UI Preview

Documentation OpenAPI
JSON brut disponible à :
http://localhost:9001/v3/api-docs

## 🔒 Tester l'authentification

### 1. Enregistrement d'un utilisateur

```bash
curl -X POST 'http://localhost:9001/api/v1/users/register' \
-H 'Content-Type: application/json' \
-d '{
  "userName": "johndoe",
  "email": "john@example.com",
  "password": "P@ssw0rd!"
}'
```
### 2. Connexion (Récupérer le JWT)
```bash
curl -X POST 'http://localhost:9001/api/v1/users/login' \
-H 'Content-Type: application/json' \
-d '{
  "email": "john@example.com",
  "password": "P@ssw0rd!"
}'
```
### Réponse exemple :
```bash
{
  "message": "User login successful",
  "data": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2huQGV4YW1wbGUuY29tIiwiaWF0IjoxNzEz...,"
}
```

### 3. Utiliser le JWT
Ajoutez le token dans le header des requêtes protégées :
```bash
curl -X GET 'http://localhost:9001/api/v1/users' \
-H 'Authorization: Bearer YOUR_JWT_TOKEN'
```

🛠 Endpoints clés
Méthode	Endpoint	Description
POST	/api/v1/users/register	Créer un compte utilisateur
POST	/api/v1/users/login	Générer un JWT
GET	/api/v1/users	Lister tous les utilisateurs (Admin)
PUT	/api/v1/users/{userId}	Mettre à jour un utilisateur
DELETE	/api/v1/users/{userId}	Supprimer un utilisateur
📦 Collection Postman
Importez cette collection Postman pour tester rapidement :

Environnement préconfiguré

Exemples de requêtes

Tests automatisés de réponse

## 🔄 Workflow de développement

Créer une branche :

bash
Copy
git checkout -b feature/nouvelle-fonctionnalite
Après modifications :

bash
Copy
mvn test # Exécuter les tests
git commit -m "feat: ajout endpoint utilisateur"
git push origin feature/nouvelle-fonctionnalite
🚨 Dépannage
Erreur 500 sur /v3/api-docs
Vérifier les annotations @Schema sur les DTOs

Nettoyer le cache Maven : mvn clean install

Problèmes de base de données
log
Copy
Connection refused: Check PostgreSQL credentials
Valider :

Serveur PostgreSQL en cours d'exécution

Config dans application.properties

JWT non reconnu
Vérifier le header Authorization: Bearer <token>

Tester avec jwt.io pour valider le token

📚 Stack technique
Backend : Spring Boot 3.4.4

Sécurité : Spring Security + JWT

Base de données : PostgreSQL

Documentation : OpenAPI 3 + Swagger UI

Build : Maven

📄 Licence
MIT License - Voir LICENSE

Copy

Ce README inclut :
- Des instructions claires pour le setup local
- Des exemples de requêtes prêts à copier/coller
- Un workflow de développement standardisé
- Un guide de dépannage pour les erreurs courantes
- Une documentation API interactive via Swagger
