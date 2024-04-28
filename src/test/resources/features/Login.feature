@smoke
Feature:Utilisateur pour la Connexion à DejaMobile
  @DEJ-4
  Scenario: Tentative de connexion avec un mot de passe invalide
    Given lutilisateur souhaite se connecter à l'application
    When il accède à l'application DejaMobile
    And l'utilisateur saisit son adresse e-mail valide
    Then si l'utilisateur saisit un mot de passe invalide
    And un message d'erreur saffiche correctement


  @DEJ-5
  Scenario: Tentative de connexion avec les champs vide
    Given lutilisateur souhaite se connecter à l'application
    When il accède à l'application DejaMobile
    And l'utilisateur laisse le champ dadresse e-mail vide
    Then l'utilisateur laisse le champ du mot de passe vide
    And un message d'erreur saffiche correctement pour les champs vide



  @DEJ-3
  Scenario:Tentative de connexion avec succes
    Given lutilisateur souhaite se connecter à l'application
    When il accède à l'application DejaMobile
    And utilisateur voit les champs "Adresse E-mail" And "Mot de passe" sur la page d'accueil
    Then  l'utilisateur saisit ses informations de connexion
    And l'utilisateur se connecte à son compte



  @DEJ-6
  Scenario: Tentative de connexion avec une adresse e-mail invalide
    Given lutilisateur souhaite se connecter à l'application
    When il accède à l'application DejaMobile
    And l'utilisateur saisit son adresse e-mail invalide
    Then si l'utilisateur saisit une mot de passe valide
    And un message d'erreur saffiche correctement
