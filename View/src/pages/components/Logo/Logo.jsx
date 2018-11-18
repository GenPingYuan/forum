import React, { PureComponent } from 'react'
import {ImgRemote} from '../index'

class Logo extends PureComponent {
    constructor(props) {
        super(props)
    }

    render(){
        return (
            <ImgRemote src={this.props.logo}/>
        )
    }
}

export default Logo