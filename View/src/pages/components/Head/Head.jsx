import React, { PureComponent } from 'react';
// import { Img } from '../index.js';
import style from './style/style.sass';
import { Logo } from '../index.js'

class Head extends PureComponent {
    constructor(props) {
        super(props);
        this.state = {
            menuList: this.props.menuList,
            logo: 'yay.jpg'
        }
    }

    componentWillMount() {
         console.log(style)
    }

    render() {
        return (
            <div className={style.nav}>
                <div>
                    <Logo />
                </div>
                <div className={style.navMenu}>
                    <div>
                        <div className={style.navMenuItem}>主页</div>
                        <div className={style.navMenuItem}>论坛</div>
                        <div className={style.navMenuItem}>游戏</div>
                        <div className={style.navMenuItem}>发呆</div>
                    </div>
                </div>
                <div>

                </div>
            </div>)
    }

}

export default Head