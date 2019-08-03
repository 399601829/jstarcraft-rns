package com.jstarcraft.rns.recommend.collaborative.rating;

import java.util.Map;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import com.jstarcraft.ai.evaluate.rating.MAEEvaluator;
import com.jstarcraft.ai.evaluate.rating.MPEEvaluator;
import com.jstarcraft.ai.evaluate.rating.MSEEvaluator;
import com.jstarcraft.rns.configure.Configurator;
import com.jstarcraft.rns.recommend.collaborative.rating.LDCCRecommender;
import com.jstarcraft.rns.task.RatingTask;

public class LDCCRecommenderTestCase {

	@Test
	public void testRecommender() throws Exception {
		Configurator configuration = Configurator.valueOf("recommend/collaborative/rating/ldcc-test.properties");
		RatingTask job = new RatingTask(LDCCRecommender.class, configuration);
		Map<String, Float> measures = job.execute();
		Assert.assertThat(measures.get(MAEEvaluator.class.getSimpleName()), CoreMatchers.equalTo(0.66628754F));
		Assert.assertThat(measures.get(MPEEvaluator.class.getSimpleName()), CoreMatchers.equalTo(0.9939437F));
		Assert.assertThat(measures.get(MSEEvaluator.class.getSimpleName()), CoreMatchers.equalTo(0.69974816F));
	}

}