package io.wxwobot.admin.web.common;

import com.jfinal.config.Routes;
import io.wxwobot.admin.web.controller.IndexController;
import io.wxwobot.admin.web.controller.KeyWordController;
import io.wxwobot.admin.web.controller.RelateController;
import io.wxwobot.admin.web.controller.RobotController;
import io.wxwobot.admin.web.controller.RobotWorkController;
import io.wxwobot.admin.web.controller.ToolController;
import io.wxwobot.admin.web.controller.UploadController;
import io.wxwobot.admin.web.interceptor.VisitLogInterceptor;

/**
 * 管理后台路由统一管理
 * @author wesleyOne
 */
public class MyRoute extends Routes {
	

	@Override
	public void config() {
		//设置视图根目录
		setBaseViewPath("/WEB-INF/templates");
		//设置拦截器，前面的先执行
		addInterceptor(new VisitLogInterceptor());
		//添加路由
		add("/", IndexController.class);
		add("/rob",RobotController.class);
		add("/robwk",RobotWorkController.class);
		add("/relate",RelateController.class);
		add("/kw",KeyWordController.class);

		add("/upload",UploadController.class);
		add("/tool",ToolController.class);
	}
}
