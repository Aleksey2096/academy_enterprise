package by.academy.pharmacy.controller;

import by.academy.pharmacy.service.util.HibernateUtil;

import javax.persistence.EntityManager;

public class Runner {
    public static void main(final String[] args) {

        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();

//		AddressEntity addressEntity = entityManager.find(AddressEntity.class, 1000000000000001L);
//		System.out.println(addressEntity);
//		ProducerEntity producerEntity1 = entityManager.find(ProducerEntity.class, 1L);
//		System.out.println(producerEntity1);
//		ProducerEntity producerEntity2 = new ProducerEntity();
//		producerEntity2.setCompanyName("TestCompany");
//		producerEntity2.setCountry(Country.JAPAN);
//		producerEntity2.setCreationDate(new Date());
//		entityManager.persist(producerEntity2);
//		System.out.println(producerEntity2);

//		ProducerEntity producerEntity3 = entityManager.find(ProducerEntity.class, 21L);
//		producerEntity3.setCountry(Country.CANADA);
//		entityManager.remove(producerEntity3);

//		entityManager.createQuery("FROM ProducerEntity WHERE companyName LIKE 'B%'").getResultList()
//				.forEach(System.out::println);

        // AddressEntity -> PersonalInfoEntity

//		PersonalInfoEntity personalInfoEntity1 = new PersonalInfoEntity();
//		personalInfoEntity1.setHealthCareCardNumber(1111L);
//		personalInfoEntity1.setSurname("TestSurname");
//		personalInfoEntity1.setName("TestName");
//		personalInfoEntity1.setBirthDate(new Date());
//		personalInfoEntity1.setPhone("testPhone");
//		personalInfoEntity1.setEmail("testEmail");
//		personalInfoEntity1.setPersonalAccount(new BigDecimal(1234.12));
//		personalInfoEntity1.setPaymentCardNumber(1234L);
//		AddressEntity addressEntity1 = new AddressEntity();
//		addressEntity1.setHealthCareCardNumber(1111L);
//		addressEntity1.setPostcode(1111);
//		addressEntity1.setCity("1111");
//		addressEntity1.setStreet("1111");
//		addressEntity1.setHouse(1111);
//		addressEntity1.setApartment(1111);
//		personalInfoEntity1.setAddressEntity(addressEntity1);
//		entityManager.persist(personalInfoEntity1);

//		ProducerEntity producerEntity5 = entityManager.find(ProducerEntity.class, 1L);
//		System.out.println(producerEntity5);
//		List<MedicineEntity> entities = producerEntity5.getMedicineEntities();
//		System.out.println(entities);

//		MedicineEntity medicineEntity2 = entityManager.find(MedicineEntity.class, 1L);
//		System.out.println(medicineEntity2.getProducerEntity());

//		ProducerEntity producerEntity6 = entityManager.find(ProducerEntity.class, 1L);
//		MedicineEntity medicineEntity3 = new MedicineEntity();
//		medicineEntity3.setTitle("TestMedicine");
//		medicineEntity3.setNonprescription(false);
//		medicineEntity3.setApprovalDate(new Date());
//		medicineEntity3.setMedicineImagePath("testPath");
//		medicineEntity3.setProducerEntity(producerEntity6);
//		entityManager.persist(medicineEntity3);

        // ProducerEntity -> MedicineEntity

//		ProducerEntity producerEntity4 = new ProducerEntity();
//		producerEntity4.setCompanyName("TestCompany");
//		producerEntity4.setCountry(Country.SWEDEN);
//		producerEntity4.setCreationDate(new Date());
//		MedicineEntity medicineEntity1 = new MedicineEntity();
//		medicineEntity1.setTitle("TestMedicine");
//		medicineEntity1.setNonprescription(false);
//		medicineEntity1.setApprovalDate(new Date());
//		medicineEntity1.setMedicineImagePath("testPath");
//		medicineEntity1.setProducerEntity(producerEntity4);
//		entityManager.persist(medicineEntity1);

        // AddressEntity -> PersonalInfoEntity -> UserEntity

//		UserEntity userEntity1 = new UserEntity();
//		userEntity1.setHealthCareCardNumber(1112L);
//		userEntity1.setLogin("dgvsdvxz");
//		userEntity1.setPassword("ger46tge4");
//		userEntity1.setRole(Role.CLIENT);
//		userEntity1.setJoinedDate(new Date());
//		userEntity1.setAvatarImagePath("dfbdgdrdgr");
//		PersonalInfoEntity personalInfoEntity2 = new PersonalInfoEntity();
//		personalInfoEntity2.setHealthCareCardNumber(1112L);
//		personalInfoEntity2.setSurname("TestSurname");
//		personalInfoEntity2.setName("TestName");
//		personalInfoEntity2.setBirthDate(new Date());
//		personalInfoEntity2.setPhone("testPhone");
//		personalInfoEntity2.setEmail("testEmail");
//		personalInfoEntity2.setPersonalAccount(new BigDecimal(1234.12));
//		personalInfoEntity2.setPaymentCardNumber(1234L);
//		AddressEntity addressEntity2 = new AddressEntity();
//		addressEntity2.setHealthCareCardNumber(1112L);
//		addressEntity2.setPostcode(1111);
//		addressEntity2.setCity("1111");
//		addressEntity2.setStreet("1111");
//		addressEntity2.setHouse(1111);
//		addressEntity2.setApartment(1111);
//		personalInfoEntity2.setAddressEntity(addressEntity2);
//		userEntity1.setPersonalInfoEntity(personalInfoEntity2);
//		entityManager.persist(userEntity1);

        // ProducerEntity -> MedicineEntity -> MedicineProductEntity

//		ProducerEntity producerEntity5 = new ProducerEntity();
//		producerEntity5.setCompanyName("TestCompany");
//		producerEntity5.setCountry(Country.SWEDEN);
//		producerEntity5.setCreationDate(new Date());
//		MedicineEntity medicineEntity2 = new MedicineEntity();
//		medicineEntity2.setTitle("TestMedicine");
//		medicineEntity2.setNonprescription(false);
//		medicineEntity2.setApprovalDate(new Date());
//		medicineEntity2.setMedicineImagePath("testPath");
//		medicineEntity2.setProducerEntity(producerEntity5);
//		MedicineProductEntity medicineProductEntity1 = new MedicineProductEntity();
//		medicineProductEntity1.setAmount(0);
//		medicineProductEntity1.setPrice(new BigDecimal(111.99));
//		medicineProductEntity1.setDosage((short) 0);
//		medicineProductEntity1.setForm(Form.LIQUID);
//		medicineProductEntity1.setMedicineEntity(medicineEntity2);
//		entityManager.persist(medicineProductEntity1);

        // (AddressEntity -> PersonalInfoEntity -> UserEntity)
        // & (ProducerEntity -> MedicineEntity -> MedicineProductEntity) ->
        // PrescriptionEntity

//		UserEntity userEntity2 = new UserEntity();
//		userEntity2.setHealthCareCardNumber(1112L);
//		userEntity2.setLogin("dgvsdvxz");
//		userEntity2.setPassword("ger46tge4");
//		userEntity2.setRole(Role.CLIENT);
//		userEntity2.setJoinedDate(new Date());
//		userEntity2.setAvatarImagePath("dfbdgdrdgr");
//		PersonalInfoEntity personalInfoEntity3 = new PersonalInfoEntity();
//		personalInfoEntity3.setHealthCareCardNumber(1112L);
//		personalInfoEntity3.setSurname("TestSurname");
//		personalInfoEntity3.setName("TestName");
//		personalInfoEntity3.setBirthDate(new Date());
//		personalInfoEntity3.setPhone("testPhone");
//		personalInfoEntity3.setEmail("testEmail");
//		personalInfoEntity3.setPersonalAccount(new BigDecimal(1234.12));
//		personalInfoEntity3.setPaymentCardNumber(1234L);
//		AddressEntity addressEntity3 = new AddressEntity();
//		addressEntity3.setHealthCareCardNumber(1112L);
//		addressEntity3.setPostcode(1111);
//		addressEntity3.setCity("1111");
//		addressEntity3.setStreet("1111");
//		addressEntity3.setHouse(1111);
//		addressEntity3.setApartment(1111);
//		personalInfoEntity3.setAddressEntity(addressEntity3);
//		userEntity2.setPersonalInfoEntity(personalInfoEntity3);
//
//		ProducerEntity producerEntity6 = new ProducerEntity();
//		producerEntity6.setCompanyName("TestCompany");
//		producerEntity6.setCountry(Country.SWEDEN);
//		producerEntity6.setCreationDate(new Date());
//		MedicineEntity medicineEntity3 = new MedicineEntity();
//		medicineEntity3.setTitle("TestMedicine");
//		medicineEntity3.setNonprescription(false);
//		medicineEntity3.setApprovalDate(new Date());
//		medicineEntity3.setMedicineImagePath("testPath");
//		medicineEntity3.setProducerEntity(producerEntity6);
//		MedicineProductEntity medicineProductEntity2 = new MedicineProductEntity();
//		medicineProductEntity2.setAmount(0);
//		medicineProductEntity2.setPrice(new BigDecimal(111.99));
//		medicineProductEntity2.setDosage((short) 0);
//		medicineProductEntity2.setForm(Form.LIQUID);
//		medicineProductEntity2.setMedicineEntity(medicineEntity3);
//
//		PrescriptionEntity prescriptionEntity1 = new PrescriptionEntity();
//		prescriptionEntity1.setUserEntity(userEntity2);
//		prescriptionEntity1.setMedicineProductEntity(medicineProductEntity2);
//		prescriptionEntity1.setAmount(100);
//		prescriptionEntity1.setDate(new Date());
//		entityManager.persist(prescriptionEntity1);

        // (AddressEntity -> PersonalInfoEntity -> UserEntity)
        // & (ProducerEntity -> MedicineEntity -> MedicineProductEntity) ->
        // OrderEntity

//		UserEntity userEntity3 = new UserEntity();
//		userEntity3.setHealthCareCardNumber(1112L);
//		userEntity3.setLogin("dgvsdvxz");
//		userEntity3.setPassword("ger46tge4");
//		userEntity3.setRole(Role.CLIENT);
//		userEntity3.setJoinedDate(new Date());
//		userEntity3.setAvatarImagePath("dfbdgdrdgr");
//		PersonalInfoEntity personalInfoEntity4 = new PersonalInfoEntity();
//		personalInfoEntity4.setHealthCareCardNumber(1112L);
//		personalInfoEntity4.setSurname("TestSurname");
//		personalInfoEntity4.setName("TestName");
//		personalInfoEntity4.setBirthDate(new Date());
//		personalInfoEntity4.setPhone("testPhone");
//		personalInfoEntity4.setEmail("testEmail");
//		personalInfoEntity4.setPersonalAccount(new BigDecimal(1234.12));
//		personalInfoEntity4.setPaymentCardNumber(1234L);
//		AddressEntity addressEntity4 = new AddressEntity();
//		addressEntity4.setHealthCareCardNumber(1112L);
//		addressEntity4.setPostcode(1111);
//		addressEntity4.setCity("1111");
//		addressEntity4.setStreet("1111");
//		addressEntity4.setHouse(1111);
//		addressEntity4.setApartment(1111);
//		personalInfoEntity4.setAddressEntity(addressEntity4);
//		userEntity3.setPersonalInfoEntity(personalInfoEntity4);
//
//		ProducerEntity producerEntity7 = new ProducerEntity();
//		producerEntity7.setCompanyName("TestCompany");
//		producerEntity7.setCountry(Country.SWEDEN);
//		producerEntity7.setCreationDate(new Date());
//		MedicineEntity medicineEntity4 = new MedicineEntity();
//		medicineEntity4.setTitle("TestMedicine");
//		medicineEntity4.setNonprescription(false);
//		medicineEntity4.setApprovalDate(new Date());
//		medicineEntity4.setMedicineImagePath("testPath");
//		medicineEntity4.setProducerEntity(producerEntity7);
//		MedicineProductEntity medicineProductEntity3 = new MedicineProductEntity();
//		medicineProductEntity3.setAmount(0);
//		medicineProductEntity3.setPrice(new BigDecimal(111.99));
//		medicineProductEntity3.setDosage((short) 0);
//		medicineProductEntity3.setForm(Form.LIQUID);
//		medicineProductEntity3.setMedicineEntity(medicineEntity4);
//
//		OrderEntity orderEntity1 = new OrderEntity();
//		orderEntity1.setLocalDateTime(LocalDateTime.now());
//		orderEntity1.setUserEntity(userEntity3);
//		orderEntity1.setMedicineProductEntity(medicineProductEntity3);
//		orderEntity1.setAmount(200);
//		orderEntity1.setPaymentCardNumber(46346374564576L);
//		orderEntity1.setContactPhone("45746574");
//		orderEntity1.setDeliveryAddress("fghfdghhsdfsvfgs");
//		entityManager.persist(orderEntity1);

        entityManager.getTransaction().commit();
        HibernateUtil.close();
    }
}
