import React, { PureComponent } from 'react'
import Logo from './Logo'
import { connect } from 'dva'

class Index extends PureComponent {
    constructor(props) {
        super(props);
    }

    componentWillMount() {
        this.props.dispatch({ type: "app/getLogo" });
    }

    render() {
        // console.log("----------")
        // console.log(this.props.app.logo);
        if(this.props.app.logo){
            return ( <Logo logo={this.props.app.logo} /> )
        }else {
            return (<span></span>)
        }
    }
}

export default connect(({ app }) => ({ app }))(Index)