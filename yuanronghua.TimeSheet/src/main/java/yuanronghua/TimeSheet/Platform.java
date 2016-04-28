package yuanronghua.TimeSheet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import yuanronghua.TimeSheet.filter.OperateFilter;

/**
 * @Title: Platform.java
 * @Package yuanronghua.TimeSheet
 * @Description: TODO(��һ�仰�������ļ���ʲô)
 * @author wb-yuanronghua
 * @date 2016��1��11�� ����10:50:30
 **/

@SpringBootApplication
@EnableAutoConfiguration
public class Platform extends SpringBootServletInitializer implements
		EmbeddedServletContainerCustomizer {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Platform.class, args);
	}

	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(8088);
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		OperateFilter operateFilter = new OperateFilter();
		filterRegistrationBean.setFilter(operateFilter);
		filterRegistrationBean.setEnabled(true);
		filterRegistrationBean.addUrlPatterns("*.do");
		filterRegistrationBean.addUrlPatterns("*.vhtml");
		filterRegistrationBean.addUrlPatterns("*.json");
		filterRegistrationBean.addInitParameter("exclusions", "login.vhtml");
		return filterRegistrationBean;
	}
}
