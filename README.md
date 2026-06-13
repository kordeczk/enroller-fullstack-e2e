# Enroller Fullstack

Witaj programisto! Dzięki temu projektowi zostaniesz *full-stack developerem*.


## Przygotowanie

Zaimportuj projekt do ulubionego IDE (np. IntelliJ, Eclipse, VS Code).

## Backend

Uruchamiany jest automatycznie, podczas wywołania testów.


## Frontend

Katalog `./main/resources/static/` zawiera już zbudowaną warstwę frontendową. Nie trzeba nic tutaj robić. 

## Uruchamianie testów

Testy można uruchomić na wiele sposobów. W przypadku korzystania z IDE najczęściej mamy taką opcję dodaną jako jedną z operacji do wykonania. NA przykłądzie intellij, klikając prawym przyciskiem myszy na katalog z testami


Testy można uruchomić na wiele sposobów. W przypadku korzystania z IDE najczęściej mamy taką opcję dostępną bezpośrednio z poziomu projektu.

### IntelliJ IDEA

Aby uruchomić pojedynczy test:

Otwórz klasę testową, np. LoginTests.
Kliknij ikonę ▶ znajdującą się obok nazwy klasy lub metody testowej.
Wybierz opcję Run.

Aby uruchomić wszystkie testy:

W widoku projektu odnajdź katalog src/test/java.
Kliknij na nim prawym przyciskiem myszy.
Wybierz opcję Run 'All Tests' lub Run Tests in 'src/test/java'.

Możliwe jest również uruchamianie wszystkich testów znajdujących się w wybranym pakiecie, np. playwright.authentication 
lub playwright.meetingsManagement, poprzez kliknięcie prawym przyciskiem myszy na nazwę pakietu i wybranie opcji Run Tests.

Maven

Jeżeli w systemie jest zainstalowany Maven, wszystkie testy można uruchomić z poziomu terminala:

mvn test