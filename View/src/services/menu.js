import { post } from 'utils/http'

export const menu = {
    filterList: () => {
        const menu = post("/menu/filterList");
        return menu.then((data) => {
            data = JSON.parse(data);
            // console.log(111);
            return data;
        })
    }
}