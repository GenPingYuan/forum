import { menu } from 'api/api'

export default {
    namespace: "head",
    state: {
        menuList: []
    },
    reducers: {
        updateState: (state, action) => {
            return Object.assign({}, state, action.afterState);
        }
    },
    effects: {
        *listQuerMenu(action, { put, call, search }) {
            // console.log(action);
            const menuList = yield call(menu.filterList);
            // console.log(menuList);
            yield put({ type: "updateState", afterState: { menuList } });
        }
    },
    subscriptions: {
       
    }

}