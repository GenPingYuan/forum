import { post,get } from 'utils/http'

export const sys = {
    getLogo: () => {
        const menu = get("/sys/getLogo");
        return menu.then((data) => {
            // console.log(data);
            return data;
        })
    }
}