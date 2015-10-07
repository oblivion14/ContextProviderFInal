package com.pineone.icbms.so.context;

import com.pineone.icbms.so.context.config.WebAppContext;
import com.pineone.icbms.so.context.model.Occurrence;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by Melvin on 15. 10. 6..
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebAppContext.class)
@WebAppConfiguration
public class TestContextProvider {

    Logger logger = LoggerFactory.getLogger((TestContextProvider.class));

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private Occurrence test;


//    @Before
//    public void initMockMvc(){
//        CharacterEncodingFilter filter = new CharacterEncodingFilter();
//        filter.setEncoding("UTF-8");
//        filter.setForceEncoding(true);
//        mockMvc = MockMvcBuilders.standaloneSetup(occurrence).addFilter(filter).build();
//    }

    @Before
    public void setUp() throws Exception{
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        test = new Occurrence();
        test.setOccrrenceID("JUNIT_ID_TEST");

    }

    public ResultActions getResultActions(Occurrence occurrence1) throws Exception{
        return mockMvc.perform(MockMvcRequestBuilders.post("/resource/occ")
        .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(occurrence1)));
    }

    @Test
    public void testMock() throws Exception{
        ResultActions resultActions = getResultActions(test);
        resultActions.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

}
