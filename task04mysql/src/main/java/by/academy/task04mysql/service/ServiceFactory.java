package by.academy.task04mysql.service;

public final class ServiceFactory {
	private static final ServiceFactory INSTANCE = new ServiceFactory();
	private final PersonCollectionCreator personCollectionCreator = new PersonCollectionCreator();
	private final PersonCollectionDaoService personCollectionDaoService = new PersonCollectionDaoService();
	private final PersonCollectionUtilService personCollectionUtilService = new PersonCollectionUtilService();
	private final CollectionPrinter collectionPrinter = new CollectionPrinter();

	private ServiceFactory() {
	}

	public static ServiceFactory getInstance() {
		return INSTANCE;
	}

	public PersonCollectionCreator getPersonCollectionCreator() {
		return personCollectionCreator;
	}

	public PersonCollectionDaoService getPersonCollectionDaoService() {
		return personCollectionDaoService;
	}

	public PersonCollectionUtilService getPersonCollectionUtilService() {
		return personCollectionUtilService;
	}

	public CollectionPrinter getCollectionPrinter() {
		return collectionPrinter;
	}
}