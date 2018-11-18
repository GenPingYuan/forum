import { menu,sys } from 'api/api'

export default {
    name: "app",
    state: {
        username: "111",
        logo: ""
    },
    // action 事件 改变state状态
    reducers: {
        updateState(state, action) {
            // console.log("updateState");
            //  console.log(action);
            return Object.assign({}, state, action.afterState);
        }
    },
    // http请求,可以 请求 查询 调用action state，
    effects: {

        *signin(action, { put, call, search }) {
            // console.log(action);
            const menuList = yield call(menu.filterList);
            // console.log(menuList);
            // 触发action
            yield put({ type: "updateState", afterState: { username: action.username } })
        },

        *getLogo(action, { put, call }) {
            const logo = yield call(sys.getLogo);
            // console.log(logo);
            yield put({type: "updateState",afterState: {logo: logo}})
        }


    },

    // 订阅一个数据源，然后根据条件 dispatch 需要的 action。
    // 数据源可以是当前的时间、服务器的 websocket 连接、keyboard 输入、geolocation 变化、history 路由变化等等。
    subscriptions: {
        setup({ dispatch, hostory }) {

        }
    }

}