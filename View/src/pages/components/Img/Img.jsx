import React, { PureComponent } from 'react';

class Img extends PureComponent {
    constructor(props) {
        super(props);
    }

    render(){
        const src = require("resource/img/" + this.props.src);
        // console.log(src)
        return (
            <img src={src} className={this.props.className}/>
        );
    }
}

export default Img