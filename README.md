# Esempi_Java
**Tecnologie utilizzate**
* IDE utilizzato: Eclipse
* Linguaggio: Java 17
* Database: MySql (utilizzato l'ausilio di MySql WorkBench 8.0)

**Utilizzo**
* installare l'IDE Eclipse
* installare Java (versione 17 o 21)
* installare MySql Connector Java (versione 8.1.0 o superiore)
* installare MySql in locale (tutorial suggerito: https://www.prisma.io/dataguide/mysql/setting-up-a-local-mysql-database)

## EsempioVideogioco 
### Funzionamento Generale
Creazione di una simulatore di Sala giochi, dove è prente un menù da cui è possibile fare log in e registrarsi come Utente o Admin (in questo caso solo log in) ed nel caso dell'utente di visualizzare i giochi, sceglerli e creare richiesti di giochi che vorrebbero che non sono presenti in catalogo. Mnetre l'admin può fare le operazioni CRUD per i videogiochi e gestire le richieste.
### Cosa si è imparato
Si è imparato ad utilizzare l'IDE ed a dare una prima struttura e flow all'applicazione.

## EsempioGestioneAuto 
### Funzionamento Generale
Creazione di un'applicazione che gestisce le operazioni CRUD sulle auto più la ricerca di queste per la targa. Queste auto vengono salvate su un database locale. Per settare il database bisogna eseguire lo script sql presente nella cartella sql, inoltre nel file 'ConnectionUtils.java' bisogna cambiare l'URI del database con il proprio; infine negli statement sono da modificare username e password, qui 'root' e 'root', con i propri. Inoltre all'inizio dell'applicazione verrà creato un file 'myCarsDB' (se non già esistente) nella cartella file, quando viene chiusa l'applicazione viene creato un backup del database in quel file.
### Cosa si è imparato
Si è imparato ad utilizzare JDBC per collegare la proprio applicazione ad un database MySql ed eseguire query; inoltre si è anche imparato a creare e gestire file.
