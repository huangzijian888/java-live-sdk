package net.polyv.live.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import net.polyv.live.bean.client.WrappedResponse;
import net.polyv.live.bean.model.ChannelAccount;
import net.polyv.live.bean.request.account.PLChannelAccountsGetRequest;
import net.polyv.live.bean.result.PLCommonListResult;
import net.polyv.live.constant.PolyvLiveConstants;
import net.polyv.live.service.PLAbstractService;
import net.polyv.live.service.PLChannelAccountService;

/**
 * <pre>
 *  直播频道的子频道接口请求实现类
 * </pre>
 *
 * @author HuangYF
 */
public class PLChannelAccountServiceImpl extends PLAbstractService implements PLChannelAccountService {

    /**
     * <pre>
     *  获取频道下所有子频道
     * </pre>
     *
     * @param channelId 频道号
     * @param request   获取频道的子频道列表的参数对象。
     * @return 子账号列表对象
     */
    public PLCommonListResult<ChannelAccount> getAccounts(int channelId, PLChannelAccountsGetRequest request) {
        String url = PolyvLiveConstants.getRealUrl(PolyvLiveConstants.CHANNEL_ACCOUNTS_GET_URL, channelId);
        WrappedResponse response = request(url, request.getParams(), GET_METHOD);
        PLCommonListResult<ChannelAccount> result = new PLCommonListResult<ChannelAccount>();
        if (response.isRequestOk()) {
            String json = JSON.toJSONString(response.getData());
            result.setT(JSONObject.parseArray(json, ChannelAccount.class));
        }
        return getResult(response, result);
    }

}
