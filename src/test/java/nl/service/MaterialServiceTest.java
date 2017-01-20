package nl.service;

import nl.TestObjectHelper;
import nl.entities.Material;
import nl.repository.MaterialRepository;
import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.*;

/**
 * Created by mzwart on 13-1-2017.
 */
@RunWith(EasyMockRunner.class)
public class MaterialServiceTest extends EasyMockSupport{

	@TestSubject
	MaterialService service = new MaterialService();

	@Mock
	private MaterialRepository materialRepository;

	@Test
	public void registerMaterial() throws Exception {
/*		Material material = TestObjectHelper.getMaterial();
		Material foundMaterial = new Material();
		expect(materialRepository.findOneByName(material.getName())).andReturn(foundMaterial);

		replayAll();

		service.registerMaterial(material);

		verifyAll();*/
	}

	@Test
	public void findMaterialByName() throws Exception {

	}

	@Test
	public void findConnectionsById() throws Exception {

	}

	@Test
	public void findById() throws Exception {

	}

}
