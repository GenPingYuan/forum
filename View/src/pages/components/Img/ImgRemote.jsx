import React, { PureComponent } from 'react';

class ImpRemote extends PureComponent {
    constructor(props) {
        super(props);
    }

    render(){
        const src = "/static/img/" + this.props.src
        // console.log(src)
        return (
            <img src={src} className={this.props.className}/>
        );
    }
}

export default ImpRemote