package net.polyv.live.service;

import net.polyv.live.bean.request.menu.PLChannelCustomMenuSetRequest;
import net.polyv.live.bean.request.menu.PLChannelMenuListGetRequest;
import net.polyv.live.bean.request.menu.PLChannelMenuSetRequest;
import net.polyv.live.bean.result.PLCommonListResult;
import net.polyv.live.bean.result.PLCommonResult;
import net.polyv.live.bean.result.menu.ChannelMenu;

/**
 * <pre>
 *  直播频道菜单相关接口
 * </pre>
 *
 * @author HuangYF
 */
public interface PLChannelMenuService extends PLBaseService {

    /**
     * <pre>
     * 获取频道菜单列表(详见http://dev.polyv.net/2018/liveproduct/l-api/hqzbxx/channel-menu-list/)
     * 该接口提供用户查询频道菜单列表信息。
     * 需要调用该接口的情况：
     * ◆ 业务需要获取频道菜单列表的信息；
     * 接口地址：http://api.polyv.net/live/v3/channel/menu/list
     * </pre>
     *
     * @param request 获取频道菜单列表的参数对象。
     * @return 频道菜单列表结果对象
     */
    PLCommonListResult<ChannelMenu> getMenus(PLChannelMenuListGetRequest request);

    /**
     * <pre>
     * 通过菜单ID设置频道菜单(详见http://dev.polyv.net/2018/liveproduct/l-api/szgkygg/update-channel-menu/)
     * 该接口提供用户设置频道菜单内容的接口。
     * 需要调用该接口的情况：
     * ◆ 业务需要修改频道菜单内容；
     * 接口地址：http://api.polyv.net/live/v3/channel/menu/update
     * </pre>
     *
     * @param request 设置频道菜单的参数对象。
     * @return 公共结果对象
     */
    PLCommonResult setMenuById(PLChannelMenuSetRequest request);

    /**
     * <pre>
     * 设置频道自定义菜单(详见http://dev.polyv.net/2017/liveproduct/l-api/szgkygg/menu/setmenu/)
     * 该接口提供用户设置频道自定义菜单内容的接口。
     * 需要调用该接口的情况：
     * ◆ 业务需要修改频道自定义菜单内容；
     * 接口地址：http://api.polyv.net/live/v2/channelSetting/{userId}/{channelId}/set-menu
     * </pre>
     *
     * @param channelId 频道ID。
     * @param userId 用户ID。
     * @param request 设置频道菜单的参数对象。
     * @return 公共结果对象
     */
    PLCommonResult setCustomMenu(int channelId, String userId, PLChannelCustomMenuSetRequest request);

}
