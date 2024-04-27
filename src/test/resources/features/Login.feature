@smoke
Feature:
   @APPSV2-1130
  Scenario: Tentative de connexion avec un mot de passe invalide
    Given lutilisateur souhaite se connecter à l'application
    When il accède à l'application DejaMobile
    And l'utilisateur saisit son adresse e-mail valide
    Then si l'utilisateur saisit un mot de passe invalide
    And un message d'erreur saffiche correctement


   @APPSV2-1131
  Scenario: Tentative de connexion avec les champs vide
    Given lutilisateur souhaite se connecter à l'application
    When il accède à l'application DejaMobile
    And l'utilisateur laisse le champ dadresse e-mail vide
    Then l'utilisateur laisse le champ du mot de passe vide
    And un message d'erreur saffiche correctement pour les champs vide



   @APPSV2-1128
  Scenario:Tentative de connexion avec succes
    Given lutilisateur souhaite se connecter à l'application
    When il accède à l'application DejaMobile
    And utilisateur voit les champs "Adresse E-mail" And "Mot de passe" sur la page d'accueil
    Then  l'utilisateur saisit ses informations de connexion
    And l'utilisateur se connecte à son compte



   @APPSV2-1129
  Scenario: Tentative de connexion avec une adresse e-mail invalide
    Given lutilisateur souhaite se connecter à l'application
    When il accède à l'application DejaMobile
    And l'utilisateur saisit son adresse e-mail invalide
    Then si l'utilisateur saisit une mot de passe valide
    And un message d'erreur saffiche correctement
